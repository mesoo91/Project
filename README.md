# Project

Practice1.java



getAdaptedIndex를 통해 N의 값이 항상 0부터 text.length-1 사이의 값을 가지도록 조정하였다.

**-1만큼 R 했다는 것은 text.length - 1 만큼 L을 한 것과 동일하다는 점을 이용하여**

따라서 L 대신 R로 값이 들어오면 N의 부호를 바꿔주고, 0부터 문자열의 길이-1 사이의 값을 가지도록 조정하여 위를 실현하도록 구현하였다.

그리고 N의 값에 따라 범위에 맞게 적당히 print 해주면 된다.

N이 3이라면 3부터 text.length까지 출력 후, 0부터 3까지 출력하여 최종적으로 문자가 이동되었음을 보여준다.



Practice2.java

Practice1.java와 비슷하게 getAdpatedIndex를 이용하여 적절하게 left, right에 따라 큐브를 스왑한다.

다만 여기에서 좀 더 편하게 구현하기 위해(horizontal, vertical에 상관 없이 구현하기 위하여) String[] str을 임시로 생성하고, 배열에서 적당히 조작(스왑)한 다음 다시 cube 변수에 넣어주도록 한다.

또한 split을 구현한 이유는 단순히 String을 받아서 인덱스에 따라 명령어를 주면 되기도 하지만 '이 있는 경우 UUR, U'UR등의 구분이 필요하므로 split 코드를 따로 작성하게 되었다.



Practice3.java

먼저 전개도 모양의 (12, 9) 배열을 만들고 전개도의 기본 값을 넣어준다.

가장 중요한 부분은 relatedData인데 

먼저 윗면은 0, 왼쪽은 1, 정면은 2와 같은 방법으로 면별로 인덱스(points 배열)를 부여한다.

그리고 Practice2.java와 같은 방법으로 배열을 밀어내는데, 그러면 큐브를 움직일 때 위치 변환이 일어나는 12개의 칸을 순서에 맞게 잘 선택 후 배열해야 한다.

12개의 칸을 순서에 맞게 배열하기 위한 세가지의 방향을 정의하였다(horizontal, verticalFront, verticalSide).

horizontal의 예를 들면, overallHorizontal이 true이다. 이는 (3, 3) 크기의 배열을 읽을 때 가로 방향으로 3개 읽을 것을 의미한다. false라면 세로 방향으로 3개 읽는다.

어떤 라인으로 3개를 읽을 지는 이후 swap함수의 파라미터에 달려 있다.

그리고 relatedIndices를 통해 방향에 따른 4가지의 영향을 미치는 면을 정의했다. horizontal은 정면, 오른쪽, 후면, 왼쪽에 영향을 미치게 된다.

lines의 경우 만약 true인 경우 해당하는 인덱스에 대해 뒤집어서 읽을 것을 정의한다. (0번 라인 읽을 거라면 대신 2번 라인을 읽는다)

directionChanged가 true인 경우 해당하는 인덱스에 대해 읽을 방향(세로, 가로)를 바꿀 것을 정의한다.

reversed의 경우 왼쪽에서 오른쪽으로 순차적으로 읽는 대신 오른쪽에서 왼쪽으로 읽게 된다. 예를 들어, 세로로 큐브를 돌린다면 후면의 경우 반대로 읽어야 순차적으로 읽히기 때문이다.

위처럼 relatedData를 정의하여 swap 함수를 작성하였다. 위 그대로 반영하여 readThreeFromCube, writeThreeFromCube 함수를 정의하여 경우의 수에 맞는 반복문을 통해 임시 배열에 읽거나 큐브에 쓰게 된다.

그리고 명령어에 따른 swap 함수를 적절히 호출하여 완성하였다.
