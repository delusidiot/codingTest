# CodingTest

Java로 자료구조와 알고리즘을 공부하고, 백준·프로그래머스·COS Pro 문제의 풀이와 복습 기록을 관리하는 저장소입니다.

**알고리즘 유형별 패키지 + 문제별 Java 파일 + 대응하는 JUnit 테스트 파일**을 기본 원칙으로 합니다. 문제마다 패키지를 새로 만들지 않으며, 여러 알고리즘이 쓰인 문제는 주 알고리즘으로 분류하고 나머지는 검색용 태그로 관리합니다.

## 학습 목표

- 자료구조와 알고리즘의 원리를 이해하고 직접 구현하기
- 문제별 풀이, 시간·공간 복잡도, 오답 원인을 기록하기
- JUnit 5로 예제·경계값·반례를 반복 검증하기
- 문제 번호, 알고리즘, 키워드로 과거 풀이를 빠르게 검색하기

## 프로젝트 구조

아래는 **권장 구조 예시**이며, 실제로 공부한 유형부터 디렉터리를 추가합니다.

```text
CodingTest/
├── src/
│   ├── main/java/codingtest/
│   │   ├── study/                          # 알고리즘 개념 학습 및 직접 구현
│   │   │   ├── sorting/
│   │   │   ├── search/
│   │   │   ├── graph/
│   │   │   └── datastructure/
│   │   └── problems/                       # 실제 코딩테스트 문제
│   │       ├── bfs/
│   │       │   ├── BOJ2178_MazeSearch.java
│   │       │   └── BOJ7576_Tomato.java
│   │       ├── hash/
│   │       │   └── PG42576_UnfinishedPlayer.java
│   │       ├── sorting/
│   │       ├── binarysearch/
│   │       ├── greedy/
│   │       ├── dp/
│   │       └── implementation/
│   └── test/java/codingtest/
│       ├── support/
│       │   └── ConsoleRunner.java          # 백준 표준입출력 테스트 도우미(선택)
│       └── problems/
│           ├── bfs/
│           │   ├── BOJ2178_MazeSearchTest.java
│           │   └── BOJ7576_TomatoTest.java
│           └── hash/
│               └── PG42576_UnfinishedPlayerTest.java
└── README.md
```

### 분류 규칙

1. `study`에는 알고리즘 구현·실험 코드를, `problems`에는 사이트 문제 풀이를 둡니다.
2. `problems` 하위에는 **알고리즘 유형별 패키지만** 만듭니다. 문제마다 별도의 패키지는 생성하지 않습니다.
3. 한 문제에 여러 알고리즘이 사용되면 **핵심 알고리즘 하나**를 패키지로 선택하고, 나머지는 `tags`에 기록합니다.
4. 풀이 파일과 테스트 파일은 `src/main/java`, `src/test/java` 아래에 **같은 패키지 경로**로 배치합니다.

## 파일 및 클래스 이름 규칙

| 플랫폼 | 풀이 클래스/파일 예시 | 테스트 클래스/파일 예시 | 제출 시 주의사항 |
| --- | --- | --- | --- |
| 백준 (BOJ) | `BOJ2178_MazeSearch.java` | `BOJ2178_MazeSearchTest.java` | 클래스명을 `Main`으로 변경하고 `package` 선언 제거 |
| 프로그래머스 | `PG42576_UnfinishedPlayer.java` | `PG42576_UnfinishedPlayerTest.java` | 클래스명을 `Solution`으로 변경하고 `package` 선언 제거 |
| COS Pro | `COS001_Example.java` | `COS001_ExampleTest.java` | 문제에서 요구하는 클래스·메서드 형식으로 변경 |

파일명 규칙은 **`플랫폼약어 + 문제번호 + _ + 영문문제명`**입니다. 문제 번호가 없으면 구별 가능한 이름을 사용합니다. 같은 패키지에 여러 문제를 보관하므로, 클래스 이름은 서로 달라야 합니다.

> 저장소에서는 구별하기 쉬운 클래스명을 사용하고, 온라인 제출 시에는 사이트가 요구하는 이름과 형식에 맞게 복사·수정합니다. 테스트 코드는 제출하지 않습니다.

## 문제 주석 및 검색 규칙

```java
package codingtest.problems.bfs;

/**
 * platform: BOJ
 * number: 2178
 * title: 미로 탐색
 * difficulty: Silver 1
 * tags: BFS, Graph, Queue, ShortestPath, 2DArray
 *
 * idea: 가중치 없는 격자에서 BFS로 최단 거리를 탐색한다.
 * complexity: Time O(N*M), Space O(N*M)
 * review: 방문 처리 시점 및 경계 조건 확인
 */
public class BOJ2178_MazeSearch {
    // 문제 풀이
}
```

IntelliJ의 **전체 검색(`Ctrl + Shift + F`)**에서 `tags: BFS`, `ShortestPath`, `platform: BOJ`, 문제 번호 등을 검색합니다. `idea`에는 **왜 이 풀이를 택했는지**, `review`에는 **실수와 복습 포인트**를 간단히 남깁니다.

## JUnit 5 테스트

문제별로 대응하는 테스트 클래스를 만들어 사이트 제공 예제와 직접 찾은 반례를 함께 검증합니다.

### 프로그래머스 / COS Pro: 반환값 검증

`src/test/java/codingtest/problems/hash/PG42576_UnfinishedPlayerTest.java`

```java
package codingtest.problems.hash;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PG42576_UnfinishedPlayerTest {
    @Test
    void example1() {
        PG42576_UnfinishedPlayer solver = new PG42576_UnfinishedPlayer();

        assertEquals("leo", solver.solution(
            new String[]{"leo", "kiki", "eden"},
            new String[]{"eden", "kiki"}
        ));
    }
}
```

위 테스트는 풀이 클래스에 `String solution(String[], String[])` 메서드가 구현된 경우를 가정합니다.

### 백준: 표준입출력 검증

백준 문제는 테스트에서 `System.in`으로 입력을 전달하고, `System.out` 출력을 비교합니다. 공통 도우미 `ConsoleRunner`를 **구현한 경우** 다음처럼 활용할 수 있습니다.

`src/test/java/codingtest/problems/bfs/BOJ2178_MazeSearchTest.java`

```java
package codingtest.problems.bfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static codingtest.support.ConsoleRunner.run;

class BOJ2178_MazeSearchTest {
    @Test
    void example1() throws Exception {
        String input = "4 6\n101111\n101010\n101011\n111011\n";
        String actual = run(input, () -> BOJ2178_MazeSearch.main(new String[0]));

        assertEquals("15", actual);
    }
}
```

`ConsoleRunner.run(String, Program)`은 표준입력을 주입하고 표준출력을 캡처한 뒤 원래 스트림을 복원하는 **테스트 전용 메서드**를 가정합니다. 해당 도우미가 없다면 별도 구현해야 합니다. 표준입출력은 프로세스 전역 상태이므로 관련 테스트는 병렬 실행하지 않습니다.

테스트에는 다음 상황도 고려합니다: **최소·최대 입력, 중복값, 경계값, 오버플로, 이전에 틀린 반례**(문제 조건에서 허용하는 범위 내).

## IntelliJ 문제 풀이 흐름

1. `codingtest.problems` 아래에서 해당 알고리즘 패키지를 선택합니다. 없는 유형은 새로 만듭니다.
2. **Settings → Editor → File and Code Templates**에 등록한 `BOJ` 또는 `Programmers/COS Pro` 템플릿으로 풀이 파일을 생성합니다.
3. 문제 번호와 이름에 맞게 **파일·클래스명**을 지정하고, 주석의 `platform`, `tags`, `idea` 등을 작성합니다.
4. `Ctrl + Shift + T`로 대응하는 JUnit 테스트 클래스를 생성하거나, 기존 테스트 템플릿을 복사합니다.
5. 예제·반례 테스트를 통과시킨 후 `complexity`, `review`를 업데이트하고 커밋합니다.

IntelliJ 파일 템플릿에 패키지 선언을 자동 삽입하려면 다음 구문을 사용할 수 있습니다.

```velocity
#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
```

문제 풀이 템플릿에서는 클래스명에 `${NAME}` 변수를 사용하면 파일을 생성할 때 입력한 이름을 재활용할 수 있습니다.

## 개발 환경

- **언어:** Java
- **IDE:** IntelliJ IDEA
- **테스트:** JUnit 5
- **빌드:** 사용하는 프로젝트 설정에 따라 Gradle 또는 Maven

Gradle(Groovy DSL)을 사용하는 경우 JUnit 설정 예시는 다음과 같습니다.

```groovy
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.12.2'
}

test {
    useJUnitPlatform()
}
```

Gradle Wrapper가 있는 프로젝트에서는 Windows PowerShell에서 `./gradlew.bat test`로 테스트할 수 있습니다.

> 이 README는 프로젝트의 **권장 구조와 사용 규칙**을 설명합니다. 예시로 표시된 파일·패키지·테스트 유틸리티·Gradle 설정은 실제 저장소 구성에 맞춰 추가하거나 조정하세요.
