package builder;

import java.util.ArrayList ;

import file_io.FileIO ;
import structures.*;

/**
 * Builds learning plans. Dirty, but works.
 * 
 * @author Lukas Pihl
 * @version 1.0
 */
public class PlanBuilder
{
   /**
    * Main method.
    * 
    * @param args       List of arguments. Not used.
    */
   public static void main(String[] args)
   {
      buildPlan1();
      buildPlan2();
      buildPlan3();
      buildPlan4();
   }
   
   /**
    * Builds Integer Plan
    */
   @SuppressWarnings("unused")
   private static void buildPlan1()
   {
      ArrayList<Question> nq;
      ArrayList<Question> bq;
      ArrayList<AnswerValue> na;
      ArrayList<AnswerValue> ba;
      Attempt a;
      ArrayList<Test> t;
      ArrayList<Goal> g;
      ArrayList<PreReq> pr;
      LearningPlan p;
      String s;
      
      g = new ArrayList<Goal>();
      pr = new ArrayList<PreReq>();
      
      //GOAL 1
      t = new ArrayList<Test>();
      
      //Test 1-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "For the number 76,123,824 which digit is in the tens place?\n\n"
            +"a) 1\tb) 2\tc) 7\td) 8\ne) 9\tf) 3\tg) 4";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "For the number 14,723,690 which digit is in the thousands place?\n\n"
            +"a) 2\tb) 9\tc) 6\td) 3\ne) 7\tf) 1\tg) 26";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "For the number 69,104,784 which digit is in the hundreds place?\n\n"
            +"a) 1\tb) 6\tc) 0\td) 8\ne) 7\tf) 9\tg) 4";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      s = "For the number 24,357,890 which digit is in the millions place?\n\n"
            +"a) 1\tb) 2\tc) 7\td) 8\ne) 9\tf) 3\tg) 4";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "For the number 12,345,567 which digit is in the ten thousands place?\n\n"
            +"a) 3\tb) 2\tc) 0\td) 9\ne) 8\tf) 4\tg) 1";
      nq.add(new Question(s, AnswerValue.F, false));
      na.add(AnswerValue.F);
      s = "For the number 7,147,896 which\nplace is the digit 4 in?\n\n"
            +"a) Ones\t\tb) Tens\nc) Hundreds\td) Thousands\ne) Ten Thousands\nf) Hundred Thousands\ng) Millions";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      s = "For the number 1,928,374 which\nplace is the digit 7 in?\n\n"
            +"a) Ones\t\tb) Tens\nc) Hundreds\td) Thousands\ne) Ten Thousands\nf) Hundred Thousands\ng) Millions";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "For the number 9,182,736 which\nplace is the digit 9 in?\n\n"
            +"a) Ones\t\tb) Tens\nc) Hundreds\td) Thousands\ne) Ten Thousands\nf) Hundred Thousands\ng) Millions";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "For the number 5,412,079 which\nplace is the digit 0 in?\n\n"
            +"a) Ones\t\tb) Tens\nc) Hundreds\td) Thousands\ne) Ten Thousands\nf) Hundred Thousands\ng) Millions";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      s = "For the number 3,572,108 which\nplace is the digit 8 in?\n\n"
            +"a) Ones\t\tb) Tens\nc) Hundreds\td) Thousands\ne) Ten Thousands\nf) Hundred Thousands\ng) Millions";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Place Value", nq, a));
      
      //Test 1-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n|4| = x\n\n"
            +"a) 0\tb) 1\tc) -4\td) -1\ne) 5\tf) 3\tg) 4";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "Solve for x\n|-5| = x\n\n"
            +"a) 0\tb) 1\tc) -4\td) -1\ne) 5\tf) 3\tg) 4";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      s = "Solve for x\n-|3| = x\n\n"
            +"a) 3\tb) 1\tc) -3\td) -1\ne) 0\tf) -4\tg) 4";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      s = "Solve for x\n|(-77)| = x\n\n"
            +"a) 0\tb) 77\tc) -77\td) 7\ne) -7\tf) 1\tg) -1";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "Solve for x\n-|-26| = x\n\n"
            +"a) 0\tb) 2\tc) -2\td) 26\ne) -26\tf) 6\tg) -6";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      s = "Solve for x\n| |-69| | = x\n\n"
            +"a) 0\tb) 69\tc) -69\td) 6\ne) -6\tf) 9\tg) -9";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "Solve for x\n|-|(-101)| | = x\n\n"
            +"a) 1\tb) -101\tc) -1\td) 101\ne) 11\tf) -11\tg) 10";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Solve for x\n-| |13| | = x\n\n"
            +"a) 1\tb) -1\tc) 3\td) -3\ne) 13\tf) 31\tg) -13";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "Solve for x\n-|-|77| | = x\n\n"
            +"a) 0\tb) 77\tc) -77\td) 7\ne) -7\tf) 1\tg) -1";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      s = "Solve for x\n-|-|-|-271| | = x\n\n"
            +"a) 27\tb) 271\tc) -271\td) -27\ne) 1\tf) 2\tg) 7";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      a = new Attempt(na);
      t.add(new Test("Absolute Value", nq, a));
      
      //test 1-3
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n5 > x\n\n"
            +"a) 5\tb) -5\tc) 6\td) 12\ne) 55\tf) 10\tg) 7";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "Solve for x\n25 < x\n\n"
            +"a) 9\tb) 25\tc) 387\td) 22\ne) -25\tf) 18\tg) 7";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      s = "Solve for x\n19 = x\n\n"
            +"a) -19\tb) 22\tc) 5\td) 128\ne) 19\tf) -22\tg) 0";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      s = "Solve for x\n189 > x\n\n"
            +"a) 189\tb) 188\tc) 191\td) 190\ne) 193\tf) 277\tg) 777";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "Solve for x\n-77 < x\n\n"
            +"a) 5\tb) -101\tc) -77\td) -80\ne) -79\tf) -200\tg) -150";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n999 = x\n\n"
            +"a) -999\tb) 999\tc) -99\td) 99\ne) 9\tf) -9\tg) 0";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "Solve for x\n-1 > x\n\n"
            +"a) 1\tb) 0\tc) -1\td) -5\ne) 10\tf) 5\tg) 6";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Solve for x\n-89 > x\n\n"
            +"a) -89\tb) -5\tc) 6\td) 12\ne) 55\tf) -90\tg) 7";
      nq.add(new Question(s, AnswerValue.F, false));
      na.add(AnswerValue.F);
      s = "Solve for x\n111 = x\n\n"
            +"a) -11\tb) -7\tc) 256\td) 88\ne) -55\tf) -10\tg) 111";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "Solve for x\n-5 > x\n\n"
            +"a) 5\tb) -5\tc) 6\td) 12\ne) 55\tf) 10\tg) -7";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      a = new Attempt(na);
      t.add(new Test("Comparison", nq, a));
      
      //Test 4
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Round 127 to the nearest ten.\n\n"
            + "a) 128\tb) 120\tc) 130\td) 100\ne) 200\tf) 127\tg) 125)";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      s = "Round 222 to the nearest hundred.\n\n"
            + "a) 220\tb) 230\tc) 300\td) 350\ne) 200\tf) 222\tg) 225)";
      nq.add(new Question(s, AnswerValue.F, false));
      na.add(AnswerValue.F);
      s = "Round 35 to the nearest ten.\n\n"
            + "a) 35\tb) 30\tc) 33\td) 40\ne) -35\tf) 100\tg) 0)";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Round 257 to the nearest thousand.\n\n"
            + "a) 1000\tb) 2000\tc) 250\td) 0\ne) 200\tf) 260\tg) 300)";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Round 12,589 to the nearest hundred.\n\n"
            + "a) 13,000\tb) 12,590\nc) 12,000\td) 12,600\ne) 10,000\tf) 12,500\ng) 12,589)";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Round -256 to the nearest ten.\n\n"
            + "a) 250\tb) -200\tc) -300\td) -250\ne) 260\tf) -260\tg) 300)";
      nq.add(new Question(s, AnswerValue.F, false));
      na.add(AnswerValue.F);
      s = "Round 987 to the nearest thousand.\n\n"
            + "a) 1000\tb) 900\tc) 0\td) 980\ne) 990\tf) 1250\tg) 777)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round 95 to the nearest ten.\n\n"
            + "a) 95\tb) 110\tc) 90\td) 100\ne) -100\tf) 98\tg) -90)";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Round 300 to the nearest ten.\n\n"
            + "a) -300\tb) 290\tc) 310\td) 333\ne) 0\tf) 300\tg) 10)";
      nq.add(new Question(s, AnswerValue.F, false));
      na.add(AnswerValue.F);
      s = "Round 247 to the nearest five.\n\n"
            + "a) 250\tb) 247\tc) 300\td) 245\ne) 200\tf) 0\tg) 5)";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      a = new Attempt(na);
      t.add(new Test("Rounding", nq, a));
      
      g.add(new Goal(null, t, false, "Properties of Numbers"));
      
      //GOAL 2
      t = new ArrayList<Test>();
      
      //TEST 1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n1 + 1 = x\n\n"
            +"a) 2\tb) 3\tc) 11\td) 0\ne) 1\tf) 7\tg) 10";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n21 + 13 = x\n\n"
            +"a) 55\tb) 8\tc) 2113\td) 34\ne) 33\tf) 43\tg) 39";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Solve for x\n987 + 1 + 126 = x\n\n"
            +"a) 1,280\tb) 1,124\nc) 988\t\td) 1,111\ne) 860\t\tf) 1,114\ng) 1278";
      nq.add(new Question(s, AnswerValue.F, false));
      na.add(AnswerValue.F);
      s = "Solve for x\n12,752 + 578 + 98 = x\n\n"
            +"a) 13,512\tb) 13,428\nc) 13,330\td) 12,076\ne) 15,978\tf) 13,131\ng) 13,031";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      s = "Solve for x\n5 + 55 + 555 + 5,555 + 55,555 = x\n\n"
            +"a) 50,000\tb) 60,000\nc) 65,432\td) 55,555\ne) 61,725\tf) -5\ng) 555,555";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      s = "Solve for x\n-5 + 1 = x\n\n"
            +"a) -10\tb) 1\tc) -6\td) -4\ne) 5\tf) -1\tg) 4";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Solve for x\n-17 + 23 = x\n\n"
            +"a) 6\tb) -40\tc) -6\td) 40\ne) 12\tf) -12\tg) 0";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n5 + (-13) = x\n\n"
            +"a) 8\tb) -18\tc) 21\td) -6\ne) 1\tf) 15\tg) -8";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "Solve for x\n-7 + (-25) = x\n\n"
            +"a) -18\tb) 18\tc) -32\td) 27\ne) -6\tf) 32\tg) 6";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      s = "Solve for x\n247 + (-89) + 5 + (-1) = x\n\n"
            +"a) -163\tb) 57\tc) 163\td) 342\ne) 162\tf) -342\tg) -57";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      a = new Attempt(na);
      t.add(new Test("Addition", nq, a));
      
      //TEST 2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 2\td) -2\ne) 11\tf) -11\tg) 0";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "Solve for x\n3 - 5 = x\n\n"
            +"a) 1\tb) -1\tc) 2\td) -2\ne) 0\tf) 8\tg) -8";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Solve for x\n87 - 32 = x\n\n"
            +"a) 55\tb) -55\tc) 119\td) -119\ne) 8\tf) 17\tg) 0";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n-58 - 78 = x\n\n"
            +"a) 136\tb) 58\tc) -78\td) -136\ne) 245\tf) 98\tg) 0";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Solve for x\n-77 - (-23) = x\n\n"
            +"a) 36\tb) -47\tc) -68\td) -54\ne) -88\tf) -124\tg) 7";
      nq.add(new Question(s, AnswerValue.D, false));
      na.add(AnswerValue.D);
      s = "Solve for x\100 - 1 = x\n\n"
            +"a) 100\tb) -1\tc) -100\td) -10\ne) -10\tf) 1\tg) 99";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "Solve for x\n-100 - 100 = x\n\n"
            +"a) 100\tb) -100\tc) 200\td) -200\ne) 1\tf) -10\tg) 0";
      nq.add(new Question(s, AnswerValue.G, false));
      na.add(AnswerValue.G);
      s = "Solve for x\n777 - 0 = x\n\n"
            +"a) 777\tb) 770\tc) 600\td) -777\ne) -5\tf) 20\tg) 0";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n0 - 548 = x\n\n"
            +"a) 548\tb) 0\tc) -0\td) -10\ne) -548\tf) 777\tg) 0";
      nq.add(new Question(s, AnswerValue.E, false));
      na.add(AnswerValue.E);
      s = "Solve for x\n0 - (-1) = x\n\n"
            +"a) 0\tb) -1\tc) 1\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.C, false));
      na.add(AnswerValue.C);
      a = new Attempt(na);
      t.add(new Test("Subtraction", nq, a));
      
      g.add(new Goal(null, t, false, "Addition & Subtraction"));
      
      //GOAL3
      t = new ArrayList<Test>();
      
      //Test1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 * 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Multiplication", nq, a));
      
      //Test 2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 / 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Division", nq, a));
      
      //Test 3
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1^1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Exponents", nq, a));
      
      g.add(new Goal(null, t, false, "Multiplication & Division"));
      
      //GOAL 4
      t = new ArrayList<Test>();
      
      //Test 1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x\n1 + 1 * 1 - 1 = x\n\n"
            +"a) 1\tb) -1\tc) 0\td) 10\ne) -10\tf) 100\tg) 5";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Order of Operations", nq, a));
      
      g.add(new Goal(null, t, false, "Order of Operations"));
      
      pr.add(new PreReq(g.get(1), g.get(3), "OO"));
      pr.add(new PreReq(g.get(2), g.get(3), "OO"));
      
      p = new LearningPlan(g, pr, "Integers");
      
      FileIO.writeLearningPlan(p);
   }
   
   /**
    * Builds Fraction plan
    */
   @SuppressWarnings("unused")
   private static void buildPlan2()
   {
      ArrayList<Question> nq;
      ArrayList<Question> bq;
      ArrayList<AnswerValue> na;
      ArrayList<AnswerValue> ba;
      Attempt a;
      ArrayList<Test> t;
      ArrayList<Goal> g;
      ArrayList<PreReq> pr;
      LearningPlan p;
      String s;
      
      g = new ArrayList<Goal>();
      pr = new ArrayList<PreReq>();
      
      //GOAL 1
      t = new ArrayList<Test>();
      
      //Test 1-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the least common\nmultiple.\n2 and 5\n\n"
            +"a) 10\tb) 2\tc) 8\td) 5\ne) 19\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Least Common Multiple", nq, a));
      
      //Test 1-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the greatest common factor.\n33\n\n"
            +"a) 11\tb) 3\tc) 33\td) 30\ne) 9\tf) 20\tg) 1";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Greatest Common Factor", nq, a));
      
      g.add(new Goal(null, t, false, "Fraction Fundamentals"));
      
      //GOAL 2
      t = new ArrayList<Test>();
      
      //Test2-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Determine the lowest factor.\n2/4\n\n"
            +"a) 1/2\tb) 1/1\tc) 1/4\td) 2/2\ne) 1/8\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Lowest Terms", nq, a));
      
      //Test 2-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Correct the imporoper fraction.\n37/4\n\n"
            +"a) 9+1/4\tb) 8+1/2\tc) 4+1/4\td) 3/2\ne) 8+1/7\tf) 4/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Improper Fractions", nq, a));
      
      g.add(new Goal(null, t, false, "Formatting"));
      pr.add(new PreReq(g.get(0), g.get(1), ""));
      
      //GOAL 3
      t = new ArrayList<Test>();
      
      //Test 3-1 
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 * 2/3 = x\n\n"
            +"a) 1/3\tb) 2/6\tc) 3/5\td) 2/5\ne) 3/2\tf) 3/6\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Multiplication", nq, a));
      
      //Test 3-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 / 2/3 = x\n\n"
            +"a) 3/2\tb) 6/4\tc) 2/6\td) 1/3\ne) 6/2\tf) 1/2\tg) 1/3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Division", nq, a));
      
      //Test 3-3
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n2^(-2) = x\n\n"
            +"a) 1/4\tb) 1/2\tc) 4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Exponents", nq, a));
      
      g.add(new Goal(null, t, false, "Multiplication & Division"));
      pr.add(new PreReq(g.get(1), g.get(2), ""));
      
      //GOAL 4
      t = new ArrayList<Test>();
      
      //Test 4-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 + 1/2 = x\n\n"
            +"a) 1\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Addition", nq, a));
      
      //Test 4-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 - 1/2 = x\n\n"
            +"a) 0\tb) 1/2\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Subtraction", nq, a));
      
      g.add(new Goal(null, t, false, "Addition & Subtraction"));
      pr.add(new PreReq(g.get(1), g.get(3), ""));
      
      //GOAL 5
      t = new ArrayList<Test>();
      
      //Test 5-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 = x\n\n"
            +"a) 2/4\tb) 4/6\tc) 3/4\td) 1/3\ne) 1/8\tf) 2/3\tg) 1/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Equivalence", nq, a));
      
      //Test 5-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1/2 < x\n\n"
            +"a) 1/3\tb) 4/6\tc) 3/4\td) 1/2\ne) 7/8\tf) 2/3\tg) 3/6";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Comparison", nq, a));
      
      g.add(new Goal(null, t, false, "Comparisons"));
      pr.add(new PreReq(g.get(1), g.get(4), ""));
      
      p = new LearningPlan(g, pr, "Fractions");
      
      FileIO.writeLearningPlan(p);
   }
   
   /**
    * Builds Decimal Plan
    */
   @SuppressWarnings("unused")
   private static void buildPlan3()
   {
      ArrayList<Question> nq;
      ArrayList<Question> bq;
      ArrayList<AnswerValue> na;
      ArrayList<AnswerValue> ba;
      Attempt a;
      ArrayList<Test> t;
      ArrayList<Goal> g;
      ArrayList<PreReq> pr;
      LearningPlan p;
      String s;
      
      g = new ArrayList<Goal>();
      pr = new ArrayList<PreReq>();
      
      //GOAL 1
      t = new ArrayList<Test>();
      
      //Test 1-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 = x\n\n"
            +"a) 1.3\tb) 1.1\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Addition", nq, a));
      
      //Test 1-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 - 0.1 = x\n\n"
            +"a) 1.1\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Subtraction", nq, a));
      
      g.add(new Goal(null, t, false, "Addition & Subtraction"));
      
      //GOAL 2
      t = new ArrayList<Test>();
      
      //Test 2-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 * 0.1 = x\n\n"
            +"a) 0.12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Multiplication", nq, a));
      
      //Test 2-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 / 0.1 = x\n\n"
            +"a) 12\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Division", nq, a));
      
      g.add(new Goal(null, t, false, "Multiplication & Division"));
      
      //GOAL 3
      t = new ArrayList<Test>();
      
      //Test 3-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n1.2 + 0.1 * 0.1 - 0.01 = x\n\n"
            +"a) 1.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Order of Operations", nq, a));
      
      g.add(new Goal(null, t, false, "Order of Operations"));
      pr.add(new PreReq(g.get(1), g.get(2), ""));
      pr.add(new PreReq(g.get(0), g.get(2), ""));
      
      //GOAL 4
      t = new ArrayList<Test>();
      
      //Test 4-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Solve for x.\n6.2 < x\n\n"
            +"a) 7.2\tb) 1.3\tc) 1.0\td) 0.1\ne) 0\tf) 2.4\tg) 4.3";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Comparison", nq, a));
      
      //Test 4-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Round to 3 decimal places.\n1.23547 < x\n\n"
            +"a) 1.235\tb) 1.2\tc) 1.23\td) 1\ne) 1.2354\tf)1.23547 \ng) 1.236";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Rounding", nq, a));
      
      //Test4-3
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to scientific notation.\n0.0012 < x\n\n"
            +"a) 1.2*10^(-3)\tb) 1.2*10^3\nc) 1.23\td) 1.2\ne) 1.2*10^(-2)\tf) 1.2*10\ng) 1.2*10^(-5)";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Scientific Notation", nq, a));
      
      //Test 4-4
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "Convert to decimal\n1/2 < x\n\n"
            +"a) 0.5\tb) 0.2\tc) 1.0\td) 0.1\ne) 0\tf) 2.1\tg) 1.2";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Converting Fractions", nq, a));
      
      g.add(new Goal(null, t, false, "Properties of Real Numbers"));
      
      p = new LearningPlan(g, pr, "Real Numbers");
      
      FileIO.writeLearningPlan(p);
   }
   
   /**
    * Builds Testing Plan
    */
   @SuppressWarnings("unused")
   private static void buildPlan4()
   {
      ArrayList<Question> nq;
      ArrayList<Question> bq;
      ArrayList<AnswerValue> na;
      ArrayList<AnswerValue> ba;
      Attempt a;
      ArrayList<Test> t;
      ArrayList<Goal> g;
      ArrayList<PreReq> pr;
      LearningPlan p;
      String s;
      
      g = new ArrayList<Goal>();
      pr = new ArrayList<PreReq>();
      
      //GOAL 1
      t = new ArrayList<Test>();
      
      //Test 1-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Test 1\nAnswer A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Test 1", nq, a));
      
      g.add(new Goal(null, t, false, "Goal 1"));
      
      //GOAL 2
      t = new ArrayList<Test>();
      
      //Test 2-1
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "Test 2\nAnswer B";
      nq.add(new Question(s, AnswerValue.B, false));
      na.add(AnswerValue.B);
      a = new Attempt(na);
      t.add(new Test("Test 2", nq, a));
      
      g.add(new Goal(null, t, false, "Goal 2"));
      pr.add(new PreReq(g.get(0), g.get(1), "PREREQ STRING TEST"));
      
      p = new LearningPlan(g, pr, "TEST PLAN");
      
      FileIO.writeLearningPlan(p);
   }
}
