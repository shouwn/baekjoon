
def gcd(num1, num2):
    """
    최대 공약수를 구하는 함수 - 유클리드 호제법 참고
    :param num1: 계산할 숫자 1
    :param num2: 계산할 숫자 2
    :return: num1 과 num2 의 최대 공약수
    """
    tmp = num1 % num2
    if tmp == 0:
        return num2
    else:
        return gcd(num2, tmp)


def lcm(num1, num2):
    """
    최소 공배수를 구하는 함수
    :param num1: 계산할 숫자 1
    :param num2: 계산할 숫자 2
    :return: num1 과 num2 의 최소 공배수
    """
    return num1 * num2 // gcd(num1, num2)


def reduce(num1, num2):
    """
    두 수를 약분해주는 함수
    :param num1: 계산할 숫자 1
    :param num2: 계산할 숫자 2
    :return: 최대 공약수로 약분된(나눠진) num1과 num2
    """
    tmp = gcd(num1, num2)
    return num1 // tmp, num2 // tmp


def refine(numerator, denominator):
    """
    분자와 분모를 Fraction 에 저장하기 쉬운 형태로 정제하는 함수
    :param numerator: 분자
    :param denominator: 분모
    :return: 분모가 0이 아니고, 분모가 음수가 아닌 분자와 분모
    """
    if denominator == 0:  # 분모가 0일 경우 무한대이기 때문에 오류 발생
        raise Exception("0은 분모에 올 수 없습니다.")
    if denominator < 0:  # 분모가 음수일 경우 분자, 분모에 -1을 곱해서 분모를 양수로 만듬
        numerator *= -1
        denominator *= -1

    return numerator, denominator  # 정제된 분자와 분모를 반환


class Fraction:

    def __init__(self, numerator, denominator):
        """
        Fraction 생성자
        :param numerator: 분자
        :param denominator: 분모
        """
        # 분자와 분모를 정제
        numerator, denominator = refine(numerator, denominator)
        # 분자와 분모를 약분해서 self 멤버 변수에 저장
        self.numerator, self.denominator = reduce(numerator, denominator)

    def get_numerator(self):
        """
        분자의 getter
        :return: 분자
        """
        return self.numerator

    def set_numerator(self, numerator):
        """
        분자의 setter
        :param numerator: 수정할 분자 값
        :return: None
        """
        # 새로 들어온 분자를 현재 분모와 약분하여 현재 객체(self)의 분자와 분모에 배정
        self.numerator, self.denominator = reduce(numerator, self.denominator)

    def get_denominator(self):
        """
        분모의 getter
        :return: 분모
        """
        return self.denominator

    def set_denominator(self, denominator):
        """
        분모의 setter
        :param denominator: 수정할 분모 값
        :return: None
        """
        # 분자와 분모를 정제
        numerator, denominator = refine(self.numerator, denominator)
        # 새로 들어온 분모를 현재 분자와 약분하여 현재 객체(self)의 분자와 분모에 배정
        self.numerator, self.denominator = reduce(numerator, denominator)

    def __str__(self):
        """
        객체를 문자열로 만드는 메소드
        :return: 분자/분모 형식의 문자열
        """
        return str(self.numerator) + "/" + str(self.denominator)

    def __add__(self, other):
        """
        + 연산자 오버로딩
        :param other: 현재 객체에 더할 다른 객체
        :return: 두 객체를 더한 값을 가지는 새로운 객체
        """
        numerator = (self.numerator * other.denominator + other.numerator * self.denominator)
        denominator = self.denominator * other.denominator
        return Fraction(numerator, denominator)

    def __mul__(self, other):
        """
        * 연산자 오버로딩
        :param other: 현재 객체에 곱할 다른 객체
        :return: 두 객체를 곱한 값을 가지는 새로운 객체
        """
        numerator = self.numerator * other.numerator
        denominator = self.denominator * other.denominator
        return Fraction(numerator, denominator)

    def __sub__(self, other):
        """
        - 연산자 오버로딩
        :param other: 현재 객체에 뺄 다른 객체
        :return: 두 객체를 뺀 값을 가지는 새로운 객체
        """
        numerator = (self.numerator * other.denominator - other.numerator * self.denominator)
        denominator = self.denominator * other.denominator
        return Fraction(numerator, denominator)

    def __truediv__(self, other):
        """
        / 연산자 오버로딩
        :param other: 현재 객체에 나눌 다른 객체
        :return: 두 객체를 나눈 값을 가지는 새로운 객체
        """
        numerator = self.numerator * other.denominator
        denominator = self.denominator * other.numerator
        return Fraction(numerator, denominator)

    def __eq__(self, other):
        """
        == 연산자 오버로딩
        :param other: 현재 객체와 같은지 비교할 다른 객체
        :return: 두 객체가 같은가? True or False
        """
        return self.numerator == other.numerator and self.denominator == other.denominator

    def __ne__(self, other):
        """
        != 연산자 오버로딩
        :param other: 현재 객체와 다른지 비교할 다른 객체
        :return: 두 객체가 다른가? True or False
        """
        return self.numerator != other.numerator or self.denominator != other.denominator

    def __lt__(self, other):
        """
        < 연산자 오버로딩
        :param other: 현재 객체가 작은지 비교할 다른 객체
        :return: 현재 객체가 다른 객체보다 작은가? True or False
        """
        return (self - other).numerator < 0

    def __le__(self, other):
        """
        <= 연산자 오버로딩
        :param other: 현재 객체가 작거나 같은지 비교할 다른 객체
        :return: 현재 객체가 다른 객체보다 작거나 같은가? True or False
        """
        return self < other or self == other

    def __gt__(self, other):
        """
        > 연산자 오버로딩
        :param other: 현재 객체가 큰지 비교할 다른 객체
        :return: 현재 객체가 다른 객체보다 큰가? True or False
        """
        return (self - other).numerator > 0

    def __ge__(self, other):
        """
        >= 연산자 오버로딩
        :param other: 현재 객체가 크거나 같은지 비교할 다른 객체
        :return: 현재 객체가 다른 객체보다 크거나 같은가? True or False
        """
        return self > other or self == other

    def print(self):
        """
        현재 객체를 출력하는 메소드
        :return: None
        """
        print(self)


f1 = Fraction(2, 3)
f2 = Fraction(3, 4)

print(f1, "+", f2, "=", f1 + f2)
print(f1, "-", f2, "=", f1 - f2)
print(f1, "*", f2, "=", f1 * f2)
print(f1, "/", f2, "=", f1 / f2)
print(f1, "==", f2, "=", f1 == f2)
print(f1, "!=", f2, "=", f1 != f2)
print(f1, "<", f2, "=", f1 < f2)
print(f1, "<=", f2, "=", f1 <= f2)
print(f1, ">", f2, "=", f1 > f2)
print(f1, ">=", f2, "=", f1 >= f2)

f1.set_denominator(4)
print(f1)

print("\n==============================\n")

f1 = Fraction(-4, 5)
f2 = Fraction(3, 2)
print(f1, "*", f2, "=", f1 * f2)

f1 = Fraction(8, 31)
f2 = Fraction(2, 3)
print(f1, "-", f2, "=", f1 - f2)

f1 = Fraction(3, 5)
f2 = Fraction(3, 7)
print(f1, "+", f2, "=", f1 + f2)

f1 = Fraction(4, 8)
f2 = Fraction(1, 2)
print(f1, "==", f2, "=", f1 == f2)

f1 = Fraction(2, 81)
f2 = Fraction(3, 9)
print(f1, ">=", f2, "=", f1 >= f2)
