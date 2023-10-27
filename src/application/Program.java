package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ChessMatch chessMath = new ChessMatch();
    while(true){
      try{
        UI.clearScreen();
        UI.printBoard(chessMath.getPieces());
        System.out.println();
        System.out.println("Source: ");
        ChessPosition source = UI.readChessPosition(sc);

        boolean[][] possibleMoves = chessMath.possibleMoves(source);
        UI.clearScreen();
        UI.printBoard(chessMath.getPieces(),possibleMoves);

        System.out.println();
        System.out.println("Target: ");
        ChessPosition target = UI.readChessPosition(sc);
        
        ChessPiece capturedPiece = chessMath.performChessMove(source, target);
      }
      catch(ChessException e){
        System.out.println(e.getMessage());
        sc.nextLine();
      }
      catch(InputMismatchException e){
        System.out.println(e.getMessage());
        sc.nextLine();
      }
    }
  }
}
