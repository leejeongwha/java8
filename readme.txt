Akka 개념

1. 액터 모델이란?
완전하게 독립된 액터와 상호 간의 메시지 교환을 통해서 충실하게 객체지향 원리를 따르면서 멀티코어 환경에서 요구되는 동시성까지 지원할 수 있는 개념

2. Akka의 3요소
1) Actor
- Actor는 UntypedActor를 상속받아 정의된 메서드를 구현
- Actor의 역할이 메시지를 받아 그 메시지를 꺼내 적절한 비즈니스 로직을 실행하는 것이기에 일반적으로 onReceive와 같은 메시지 도착에 따른 콜백 메서드를 구현하여 로직을 실행

2) ActorSystem
- ActorSystem은 역할측면에서 볼 때 스프링의 applicationContext와 같다고 볼 수 있음. Actor의 라이프사이클이 모두 ActorSystem 안에서 이루어지기 때문

3) ActorRef
- ActorRef는 Actor를 감싸고 있는 Wrapper
- 모든 Actor들은 ActorRef안에 숨겨져서 상호간의 메시지를 주고 받는다

Akka 실습
1. start
2. hierachy
3. crash
4. statemachine
5. router
6. agent
7. cluster??

