@testable import Solution

import XCTest

final class SolutionTests: XCTestCase {
    func test() throws {
        XCTAssertEqual(Solution().solution(), false)
    }
}
