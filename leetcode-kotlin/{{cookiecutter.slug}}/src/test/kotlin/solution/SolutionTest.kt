package solution

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.matchers.equals.shouldBeEqual

class SolutionTest : FunSpec({
  val sut = Solution()

  listOf(
    row("foo", "bar", "baz"),
  ).forEach {
    test("${it.a} should be equal to ${it.b} + ${it.c}") {
      it.a.shouldBeEqual(it.b + it.c)
    }
  }
})
