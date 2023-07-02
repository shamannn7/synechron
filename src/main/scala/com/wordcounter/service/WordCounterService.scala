package com.wordcounter.service

import scala.concurrent.ExecutionContext
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model.{HttpResponse, StatusCode}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.wordcounter.lib.WordCounter

import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model._

case class Count(count: Int)

trait WordCounterService {

  implicit val system: ActorSystem

  implicit def executor: ExecutionContext

  val routes: Route = {
    pathPrefix("wordcounter") {
      get {
        parameters('word.as[String]) { word: String =>
          val count = WordCounter.getCount(word).toString
          val reply = s"\nThe $word count is $count"
          complete(200 , reply)
        }
      } ~
      post {
        parameters('word.as[String]) { word: String =>
          WordCounter.addWords(List(word))
          complete(200, s"\nThe $word was added.")
        }
      }
    }
  }
}

object WordCountMicroservice extends App with WordCounterService {

  override implicit val system: ActorSystem = ActorSystem()
  override implicit val executor: ExecutionContext = system.dispatcher

  Http().newServerAt("localhost", 8080).bindFlow(routes)
}
