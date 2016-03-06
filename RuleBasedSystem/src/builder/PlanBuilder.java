package builder;

import java.util.ArrayList ;

import file_io.FileIO ;
import structures.*;

public class PlanBuilder
{
   
   public static void main(String[] args)
   {
      buildPlan1();
      buildPlan2();
      buildPlan3();
      buildPlan4();
   }
   
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Comparison", nq, a));
      
      //Test 4
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Multiplication", nq, a));
      
      //Test 2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Division", nq, a));
      
      //Test 3
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Least Common Multiple", nq, a));
      
      //Test 1-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Lowest Terms", nq, a));
      
      //Test 2-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Multiplication", nq, a));
      
      //Test 3-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Division", nq, a));
      
      //Test 3-3
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Addition", nq, a));
      
      //Test 4-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Equivalence", nq, a));
      
      //Test 5-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Comparison", nq, a));
      
      g.add(new Goal(null, t, false, "Comparisons"));
      pr.add(new PreReq(g.get(1), g.get(4), ""));
      
      p = new LearningPlan(g, pr, "Fractions");
      
      FileIO.writeLearningPlan(p);
   }
   
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Addition", nq, a));
      
      //Test 1-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Multiplication", nq, a));
      
      //Test 2-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
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
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Comparison", nq, a));
      
      //Test 4-2
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Rounding", nq, a));
      
      //Test4-3
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Scientific Notation", nq, a));
      
      //Test 4-4
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Converting Fractions", nq, a));
      
      //Test 4-5
      nq = new ArrayList<Question>();
      bq = new ArrayList<Question>();
      na = new ArrayList<AnswerValue>();
      ba = new ArrayList<AnswerValue>();
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      s = "A";
      nq.add(new Question(s, AnswerValue.A, false));
      na.add(AnswerValue.A);
      a = new Attempt(na);
      t.add(new Test("Rational & Irrational", nq, a));
      
      g.add(new Goal(null, t, false, "Properties of Real Numbers"));
      
      p = new LearningPlan(g, pr, "Real Numbers");
      
      FileIO.writeLearningPlan(p);
   }
   
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
