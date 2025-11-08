package solution
{% if cookiecutter.test_framework == "assertk" %}
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.tableOf
import kotlin.test.Test

class SolutionTest {
  @Test
  fun solution() {
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
import io.kotest.datatest.withData
import io.kotest.matchers.equals.shouldBeEqual

class SolutionTest : FunSpec({
  context("solution") {
    data class TestCase(val expected: Boolean, val given: Boolean)

    withData(
      TestCase(true, false),
      TestCase(true, true),
    ) { (expected, _) ->
      val sut = Solution()

      sut.solution() shouldBeEqual expected
    }
  }
})
{% endif %}

