@testable import Solution

import XCTest

final class SolutionTests: XCTestCase {
    func test() throws {
        let sut = Solution()

        [
            TestCase(expected: false, given: 1),
        ].forEach { t in
            let actual = sut.solution(t.given)

            XCTAssertEqual(t.expected,
                           actual,
                           "with input \(String(describing: t.given))")
        }
    }
}

private struct TestCase {
    let expected: Bool
    let given: Int
}
