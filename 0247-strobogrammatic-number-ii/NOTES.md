<문제 이해>
정수 N을 주는데,
길이가 N인 정수 중 180도 회전해도 동일한 생김새를 가진 숫자들을 반환하라.
유력 후보 : 0 1 8
후보 : 6 9
​
<풀이>
길이가 N인 수를 모두 돌면서 조건 체크하기엔 너무 낭비
길이가 홀수인지 짝수인지를 파악하고,
짝수면 양쪽으로 하나씩 추가하면서
홀수면 가운데 하나 두고 양쪽으로 하나씩 추가하면서 숫자를 만들어야 할 듯