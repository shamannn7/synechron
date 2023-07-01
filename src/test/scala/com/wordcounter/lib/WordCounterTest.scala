package com.wordcounter.lib

import org.scalatest.funsuite.AnyFunSuite

class WordCounterTest extends AnyFunSuite{
  test("count one word") {
    assert(WordCounter.getCount("test") === 0)

    WordCounter.addWords(List("test"))

    assert(WordCounter.getCount("test") === 1)
  }

  test("count several words") {
    assert(WordCounter.getCount("testTwo") === 0)

    WordCounter.addWords(List("testTwo", "testTwo"))

    assert(WordCounter.getCount("testTwo") === 2)
  }

  test("not count non alphabetic words") {
    assert(WordCounter.getCount("1") === 0)

    WordCounter.addWords(List("1"))

    assert(WordCounter.getCount("1") === 0)
  }

  test("count translation") {
    assert(WordCounter.getCount("") === 0)

    WordCounter.addWords(List("1"))

    assert(WordCounter.getCount("1") === 0)
  }

}
