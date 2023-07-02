package com.wordcounter.lib

import scala.collection.concurrent.TrieMap


object WordCounter {
  val dictionary: TrieMap[String, Int] = TrieMap[String, Int]()
  val translator = new Translator()

  def addWords(words: List[String]): Unit ={
    for(word <- words){
      val translated = translator.translate(word)
      val countMaybe: Option[Int] = dictionary.get(translated)
      if(translated.forall(_.isLetter))
        if (countMaybe.isDefined){
           val count = countMaybe.get + 1
           dictionary.put(translated, count)
        }
        else{
            dictionary.put(translated, 1)
        }
    }
  }

  def getCount(word : String): Int ={
      dictionary.getOrElse(word, 0)
  }
}

class Translator {
  def translate(word: String): String ={
      word
  }
}
