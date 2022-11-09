# 문제 이해
각 학생들의 점수 중 최고 점수 5개씩 뽑아서 평균낸 것을 반환

2차원 배열 sort, 0 인덱스는 오름차순, 1 인덱스는 내림차순

# 추가 공부
### 객체 비교
1. primitive type 말고 reference type의 경우, 정렬 시 Comparator 혹은 Comparable interface 사용이 요구 된다. 
2. Comparator는 서로 다른 두 객체를 비교하는 compare 함수를, Comparable은 자기 자신과 다른 객체를 비교하는 compareTo 함수 구현을 요구한다.

### Collections.sort and Arrays.sort
1. Collection.sort 함수의 경우 전달 받은 객체 리스트를 정렬할 때, 내부적으로 배열로 변환 후에 Arrays.sort 함수를 호출한다.
2. Arrays.sort 함수의 시간 복잡도는 O(n log n) 이다. → ~~아직 공부하지 않은 두 가지의 정렬 방식을 사용한다.~~
3. 예를 들어서 2차원 배열을 Arrays.sort 함수로 정렬하는 경우 compare 함수를 overriding 할텐데, 최악의 경우 3번의 비교를 하게 된다. But! 상수는 신경쓰지 않기 때문에 결국 시간복잡도가 O(n log n) 이라고 생각해도 무방하다.
