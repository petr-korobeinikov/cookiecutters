class SolutionSuite extends munit.FunSuite {
  test("solution") {
    val sut = Solution()

    assertEquals(sut.solution(), true)
  }
}
