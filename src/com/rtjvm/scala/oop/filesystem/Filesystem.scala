package com.rtjvm.scala.oop.filesystem

import com.rtjvm.scala.oop.commands.Command
import com.rtjvm.scala.oop.files.Directory

object Filesystem extends App {

  val root = Directory.ROOT

  State(root, root).show

  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
    val newState = Command.from(newLine).apply(currentState)
    newState.show
    newState
  })

}
