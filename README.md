# Project

Practice1.java
getAdaptedIndex를 통해 N의 값이 항상 0부터 text.length-1 사이의 값을 가지도록 조정
또한 -1만큼 R 했다는 것은 text.length - 1 - 1 만큼 L을 한 것과 동일
따라서 L 대신 R로 값이 들어오면 N의 부호를 바꿔주고, 0부터 문자열의 길이-1 사이의 값을 가지도록 조정함

그리고 N의 값에 따라 범위에 맞게 적당히 print 해주면 된다.
N이 3이라면 3부터 text.length까지 출력 후, 0부터 3까지 출력하여 최종적으로 문자가 이동되었음을 보여준다.
