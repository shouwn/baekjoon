package test.lc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E3 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            List<Table> tables = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                Table table = new Table();

                int rowCount = Integer.parseInt(br.readLine());
                table.header.addAll(Arrays.asList(br.readLine().split(" ")));

                for (int j = 1; j < rowCount; j++) {
                    String[] row = br.readLine().split(" ");
                    table.rows.put(Integer.valueOf(row[0]), Arrays.asList(row));
                }

                tables.add(table);
            }

            System.out.println(tables.get(0).leftJoin(tables.get(1)).toString());
        }
    }

    private static class Table {
        List<String> header = new ArrayList<>();
        TreeMap<Integer, List<String>> rows = new TreeMap<>();

        public Table() {

        }

        public Table(List<String> header, TreeMap<Integer, List<String>> rows) {
            this.header = header;
            this.rows = rows;
        }

        public Table leftJoin(Table other) {

            List<String> newHeader = new ArrayList<>(this.header);
            newHeader.addAll(other.header.subList(1, other.header.size()));

            TreeMap<Integer, List<String>> newRows = new TreeMap<>();

            for (Map.Entry<Integer, List<String>> e : rows.entrySet()) {
                List<String> row = new ArrayList<>(e.getValue());

                if (other.rows.containsKey(e.getKey())) {
                    row.addAll(other.rows.get(e.getKey()).subList(1, other.header.size()));
                } else {
                    List<String> nullRow = Stream.iterate("NULL", s -> s).limit(other.header.size() - 1)
                            .collect(Collectors.toList());

                    row.addAll(nullRow);
                }

                newRows.put(e.getKey(), row);
            }

            return new Table(newHeader, newRows);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(String.join(" ", this.header));

            this.rows.values()
                    .forEach(row -> sb.append("\n").append(String.join(" ", row)));

            return sb.toString();
        }
    }
}
