package test.uc;

import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.time.temporal.ChronoUnit.SECONDS;

public class E6 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new E6().solution(2,
                new String[] {"a request 09:00:00", "b request 09:01:00", "c request 09:01:01"})));
    }

    public String[] solution(int totalTicket, String[] logs) {
        List<Request> requestList = Arrays.stream(logs)
                .map(this::makeRequest)
                .collect(Collectors.toList());

        requestList.add(new Request("MASTER", "request", "10:00:00"));

        requestList.sort(Comparator.comparing(Request::getRequestTime));

        System.out.println(requestList);

        Provider provider = new Provider(60, totalTicket,
                LocalTime.of(9, 0), LocalTime.of(10, 0));

        requestList.forEach(provider::request);

        String[] result = provider.ticketOwners.toArray(new String[0]);
        Arrays.sort(result);

        return result;
    }

    private Request makeRequest(String log) {
        String[] splitLog = log.split(" ");

        return new Request(splitLog[0], splitLog[1], splitLog[2]);
    }

    static class Provider {
        int limitSecond = 60;

        int ticket;
        Set<String> ticketOwners = new HashSet<>();
        Request currentRequest;

        LocalTime startTime;
        LocalTime endTime;

        public Provider(int limitSecond, int ticket, LocalTime startTime, LocalTime endTime) {
            this.limitSecond = limitSecond;
            this.ticket = ticket;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public void request(Request request) {

            if (!checkCondition(request)) {
                return;
            }

            // (09:00:00에 request 후 09:00:59에 leave 시 구매 실패, 09:00:00에 request 후 09:01:00에 leave 시 구매 성공)
            if (currentRequest != null) {

                long diff = Math.abs(SECONDS.between(request.requestTime, currentRequest.requestTime));

                if (diff >= limitSecond) {
                    ticketOwners.add(currentRequest.user);

                    if (diff > limitSecond) {
                        currentRequest = null;
                    }
                }
            }

            if (request.method == Request.Method.LEAVE) {
                currentRequest = null;
            } else if (currentRequest == null) { // method == request
                currentRequest = request;
            }
        }

        private boolean checkCondition(Request request) {
            if (request.requestTime.isBefore(startTime) || request.requestTime.isAfter(endTime)) {
                return false;
            }

            return ticketOwners.size() != ticket;
        }
    }

    // must be value object
    // 현재는 그냥 만듬
    static class Request {
        enum Method {
            REQUEST, LEAVE;
        }

        String user;
        Method method;
        LocalTime requestTime;

        public Request(String user, String method, String requestTime) {
            this.user = user;
            this.method = Method.valueOf(method.toUpperCase());
            this.requestTime = LocalTime.parse(requestTime);
        }

        public LocalTime getRequestTime() {
            return requestTime;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "user='" + user + '\'' +
                    ", method=" + method +
                    ", requestTime=" + requestTime +
                    '}';
        }
    }

    // 문제 잘못 이해하고 만듬
    static class JsonParser {
        static final Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        public static List<String> jsonToStringList(String json) {
            Matcher matcher = pattern.matcher(json);

            List<String> list = new ArrayList<>();

            while (matcher.find()) {
                list.add(matcher.group(1));
            }

            return list;
        }

        public static String stringListToJson(List<String> list) {
            List<String> stringList = list.stream()
                    .map(s -> "\"" + s + "\"")
                    .collect(Collectors.toList());

            return "[" + String.join(", ", stringList) + "]";
        }
    }
}
