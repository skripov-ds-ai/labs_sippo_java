package com.examples.skripov.sippo;

import com.examples.skripov.sippo.lesson1.exceptions.NotConsoleOrFileException;
import com.examples.skripov.sippo.lesson1.exceptions.NotTrueOrFalseException;
import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.DichotomySearchExtremum;
import com.examples.skripov.sippo.lesson1.search_extremum.FibonacciSearchExtremum;
import com.examples.skripov.sippo.lesson1.search_extremum.GoldenSectionSearchExtremum;
import com.examples.skripov.sippo.lesson1.search_extremum.exceptions.FibonacciOverFlowException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.Function;
import com.examples.skripov.sippo.lesson1.search_extremum.function.Function4SecondTest;
import com.examples.skripov.sippo.lesson1.search_extremum.function.SinFunction;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Sippo {

    private static void oldMain() {
        // System.out.println( "Hello World!" );
        Function sin = new SinFunction(0, Math.PI, 1, 1);
        try {
            System.out.println("sin(п/2) = " + sin.compute(Math.PI / 2));
            Point2D point = DichotomySearchExtremum.getExtremum(1e-9, 1000, false, sin);
            System.out.println(point);
            Point2D point1 = GoldenSectionSearchExtremum.getExtremum(1e-9, 1000, false, sin);
            System.out.println(point1);
            Point2D point2 = FibonacciSearchExtremum.getExtremum(1e-9, 7, false, sin);
            System.out.println(point2);

        } catch (IncorrectDomainException e) {
            e.printStackTrace();
        } catch (OutOfSegmentException e) {
            e.printStackTrace();
        } catch (OutOfDomainException e) {
            e.printStackTrace();
        } catch (FibonacciOverFlowException e) {
            e.printStackTrace();
        }
    }

    private static double A = 2, B = -1, C = 1;

    private static Function myFunction(double a, double b) {
        Function function = new Function4SecondTest(a, b, A, B, C);
        return function;
    }

    private static String myFunctionString = "2*x^2 - e^x";
    private static String hello = "Hello, dear user!\nToday we have function: " + myFunctionString;
    private static String giveMeNumOfIterations = "Please, enter count of iterations:";
    private static String giveMeEpsilon = "Please, enter epsilon for our search method:";
    private static String giveMeA = "We search extremum on (a; b).\nPlease, give a:";
    private static String giveMeB = "Enter b:";
    private static String aboutMethod = "We will search extremum of this function by Fibonacci Numbers Method.";
    private static String tellMeMaxOrMin = "Enter true - for minimum or false - for maximum";

    private static String tellMeFileOrConsole = "What kind of resources will you use for this program(file or console)?\nPlease enter \"file\" without quotes for file input; \"console\" without quotes for console input.";

    private static String giveMeNameOfFile = "Enter name of file:";

    private static boolean isFile;
    private static String nameOfFile = "";

    private static String fileStr = "file";
    private static String consoleStr = "console";

    private static String minim = "Minimum: ";
    private static String maxim = "Maximum: ";

    private static String strTrue = "true";
    private static String strFalse = "false";


    private static void menu() throws NotTrueOrFalseException, FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException, NotConsoleOrFileException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(hello);
        System.out.println(aboutMethod);
        System.out.println();

        System.out.println(tellMeFileOrConsole);
        String fileConsoleStr = scanner.nextLine().toLowerCase();

        if (fileStr.equals(fileConsoleStr)) {
            isFile = true;
        } else if (consoleStr.equals(fileConsoleStr)) {
            isFile = false;
        } else {
            throw new NotConsoleOrFileException("fileConsoleStr = " + fileConsoleStr);
        }

        if (isFile) {
            System.out.println(giveMeNameOfFile);
            nameOfFile = "src/main/resources/" + scanner.nextLine().trim() + ".txt";
            //System.out.println("==== " + (new File(nameOfFile)).getPath());
            File file = new File(nameOfFile);
            scanner = new Scanner(file);
        }

        if (!isFile) {
            System.out.println(tellMeMaxOrMin);
        }

        String minimumStr = scanner.nextLine().toLowerCase();
        boolean minimum;

        if (strTrue.equals(minimumStr)) {
            minimum = true;
        } else if (strFalse.equals(minimumStr)) {
            minimum = false;
        } else {
            throw new NotTrueOrFalseException("minimumStr = " + minimumStr);
        }

        if (!isFile) {
            System.out.println(giveMeA);
        }
        double a = scanner.nextDouble();

        if (!isFile) {
            System.out.println(giveMeB);
        }
        double b = scanner.nextDouble();

        if (!isFile) {
            System.out.println(giveMeEpsilon);
        }
        double eps = scanner.nextDouble();

        if (!isFile) {
            System.out.println(giveMeNumOfIterations);
        }
        int iterations = scanner.nextInt();

        Point2D result = FibonacciSearchExtremum.getExtremum(eps, iterations, minimum, myFunction(a, b));

        System.out.println((minimum ? minim : maxim) + result);

        scanner.close();
    }

    public static void main( String[] args ) throws NotTrueOrFalseException, IncorrectDomainException, OutOfSegmentException, OutOfDomainException, FibonacciOverFlowException, NotConsoleOrFileException, FileNotFoundException {
        menu();
    }
}
