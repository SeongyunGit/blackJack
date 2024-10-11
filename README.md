# 프리코스 블랙잭 미션 구현해보기
## 기능 요구 사항
- 블랙잭 게임을 진행하는 프로그램을 구현한다. 블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

- 플레이어는 게임을 시작할 때 배팅 금액을 정해야 한다. 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.

- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다. 단, 카드를 추가로 뽑아 21을 초과할 경우 배팅 금액을 모두 잃게 된다.

- 처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 배팅 금액의 1.5 배를 딜러에게 받는다. 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 배팅한 금액을 돌려받는다.

- 딜러는 처음에 받은 2장의 합계가 16이하이면 반드시 1장의 카드를 추가로 받아야 하고, 17점 이상이면 추가로 받을 수 없다. 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리해 배팅 금액을 받는다.

- 딜러는 2장의 처음 2장의 카드를 뽑은 후 카드 중 하나의 카드만 보여준다.

- 결과 비교는 딜러와 각각 플레이어 개별로 진행되며 승리 시 배팅한 금액만큼 수익이 발생하고, 무승부 시 배팅한 금액을 돌려받거, 패배 시 배팅한 금액을 잃는다.

## 프로그램 실행 결과
```
게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)
pobi, jason

pobi의 배팅 금액은?
10000

jason의 배팅 금액은?
20000

딜러와 pobi, jason에게 2장을 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y

pobi카드: 2하트, 8스페이드, A클로버

pobi는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n

jason은 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n

jason카드: 7클로버, K스페이드

딜러는 16이하라 한 장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과 21
jason카드: 7클로버, K스페이드 - 결과 17

## 최종 수익
딜러: 10000
pobi: 10000
jason: -20000
```

## 프로그래밍 요구사항
- [ ] 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - [ ] 최대한 10라인을 넘지 않기 위해 노력하고, 정말 힘든 경우 15라인까지 허용한다.
  - [ ] 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- [ ] indent(인덴트, 들여쓰기) depthfmf 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - [ ] 최대한 1을 유지하기 위해 노력하고, 정말 힘든 경우 2까지 허용한다.
  - [ ] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- [ ] 함수(또는 메소드)의 인자 수를 3개까지만 허용한다. 4개 이상은 허용하지 않는다.
### 프로그래밍 요구사항
- [ ] Card, Player, Dealer 클래스를 활용해 구현한다.
- [ ] 각 클래스의 기본 생성자를 추가할 수 없다.
- [ ] 각 클래스에 필드(인스턴스 변수)를 추가할 수 없다.
- [ ] 필드(인스턴스 변수)의 접근 제어자 private을 변경할 수 없다.
- [ ] 중복 코드를 제거해 본다