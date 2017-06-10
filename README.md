### 8조 Homework BlackJack 과제
* com.hw.team8.blackjack (main/java)
    * class BlackjackApplication
    * class Game
    * class Player
    * class PlayerHand      (이상현)
    * class Card            (석지훈)
    * class Deck            (정윤수)
    * class CardsEvaluator  (임대영)
    * enum  Suit
    * enum  GameResult

* com.hw.team8.blackjack (test/java)
    * class GameTest
    * class PlayerTest
    * class PlayerHandTest
    * class CardTest
    * class DeckTest
    * class CardsEvaluatorTest

* 프로젝트 설명
    * 본 프로젝트는 블랙잭이다. 
    * 카드 숫자를 합쳐 가능한 21에 가깝게 만들면 이긴다.
    * 처음 받은 2장이 합쳐서 21이 나오는 경우 블랙잭이 되며 21이 되지 않았을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.
    * 21을 초과하게(22 이상) 되었을 경우에는 '버스트'로 딜러의 결과에 관계없이 무조건 근 금액을 잃게 된다.
    * 숫자카드인 2~10은 그 숫자대로 점수를 세고, K.Q.J는 10점으로 계산한다.
    * 단, 에이스(A)는 1, 11 둘중의 하나로 계산하는데, 플레이어가 유리한 쪽으로 계산을 한다.
    * 먼저 100달러를 가지고있고 배팅 금액을 정한다.
    * 플레이어와 딜러는 카드 두장을 기본적으로 지급받는다.
    * 딜러는 카드 1장을 공개하고 플레이어는 카드를 더 뽑을지 그만둘지 정한다.
    * 더 뽑는것을 그만두면 카드 숫자를 합쳐 21에 가까운 사람이 이긴다.
    
  