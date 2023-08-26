import XCTest
@testable import Solution

final class SolutionTests: XCTestCase {
    func test() throws {
        XCTAssertEqual(Solution().solution(), false)
    }
}
