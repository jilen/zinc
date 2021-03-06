package sbt
package internal
package inc

class HashSpec extends UnitSpec {
  it should "reject goddleygook" in reject("goddleygook")
  it should "accept lower hex" in accept("0123456789abcdef")
  it should "accept upper hex" in accept("0123456789ABCDEF")
  it should "reject odd number" in reject("012345678")

  private def reject(s: String) = assert(run(s).isEmpty)
  private def accept(s: String) = assert(run(s) exists (_.hexHash == s))
  private def run(s: String) = Hash fromString s"hash($s)"
}
