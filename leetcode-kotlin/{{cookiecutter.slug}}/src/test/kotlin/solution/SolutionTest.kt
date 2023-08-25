package solution
{% if cookiecutter.test_framework == "assertk" %}
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.tableOf
import kotlin.test.Test

class SolutionTest {
  @Test
  fun intToRoman() {
    val sut = Solution()

    tableOf("expected", "given")
      .row(true, "foo")
      .forAll { expected, given ->
        assertThat(sut.solution()).isEqualTo(expected)
      }
  }
}
{% elif cookiecutter.test_framework == "kotest" %}
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
{% endif %}
