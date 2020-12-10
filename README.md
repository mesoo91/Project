# Project

Practice1.java



getAdaptedIndex를 통해 N의 값이 항상 0부터 text.length-1 사이의 값을 가지도록 조정하였다. 또한
**-1만큼 R 했다는 것은 text.length - 1 - 1 만큼 L을 한 것과 동일하다는 점을 이용하였다.**
따라서 L 대신 R로 값이 들어오면 N의 부호를 바꿔주고, 0부터 문자열의 길이-1 사이의 값을 가지도록 조정하여 위를 실현하도록 구현하였다.

그리고 N의 값에 따라 범위에 맞게 적당히 print 해주면 된다.
N이 3이라면 3부터 text.length까지 출력 후, 0부터 3까지 출력하여 최종적으로 문자가 이동되었음을 보여준다.



Practice2.java

Practice1.java와 비슷하게 getAdpatedIndex를 이용하여 적절하게 left, right에 따라 큐브를 스왑한다.
다만 여기에서 좀 더 편하게 구현하기 위해(horizontal, vertical에 상관 없이 구현하기 위하여) String[] str을 임시로 생성하고, 배열에서 적당히 조작(스왑)한 다음 다시 cube 변수에 넣어주도록 한다.
