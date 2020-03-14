package core;

import com.huangyuanqin.www.core.Counter;
import com.huangyuanqin.www.core.impl.CounterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hyq
 * @date : 2020/3/14  17:32
 */
public class CounterTest {
    private Counter counter = new CounterImpl();

    @Test
    public void countCharTest(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test.c";
        Assertions.assertEquals(4L,counter.countChar(path));

        path = "UnExistsPath";
        Assertions.assertEquals(-1L,counter.countChar(path));
    }

    @Test
    public void countWordTest(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test.c";
        Assertions.assertEquals(1L,counter.countWord(path));

        path = "UnExistsPath";
        Assertions.assertEquals(-1L,counter.countWord(path));
    }

    @Test
    public void countLineTest(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test.c";
        Assertions.assertEquals(1L,counter.countLine(path));

        path = "UnExistsPath";
        Assertions.assertEquals(-1L,counter.countLine(path));
    }

    @Test
    public void countCharTest0(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test.c";
        List<String> list = new LinkedList<String>();
        list.add(path);
        Assertions.assertEquals(4L,counter.countChar(list));
    }

    @Test
    public void countWordTest0(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test.c";
        List<String> list = new LinkedList<String>();
        list.add(path);
        Assertions.assertEquals(1L,counter.countWord(list));
    }

    @Test
    public void countLineTest0(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test.c";
        List<String> list = new LinkedList<String>();
        list.add(path);
        Assertions.assertEquals(1L,counter.countLine(list));
    }

    @Test
    public void countEmptyLineTest(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test2.c";
        Assertions.assertEquals(2L,counter.countEmptyLine(path));

        path = "UnExistsPath";
        Assertions.assertEquals(-1L,counter.countEmptyLine(path));
    }

    @Test
    public void countAnnotationLineTest(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test2.c";
        Assertions.assertEquals(4L,counter.countAnnotationLine(path));

        path = "UnExistsPath";
        Assertions.assertEquals(-1L,counter.countAnnotationLine(path));
    }

    @Test
    public void countCodeLineTest(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test2.c";
        Assertions.assertEquals(1L,counter.countCodeLine(path));
    }

    @Test
    public void countEmptyLineTest0(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test2.c";
        List<String> list = new LinkedList<String>();
        list.add(path);
        Assertions.assertEquals(2L,counter.countEmptyLine(list));
    }

    @Test
    public void countAnnotationLineTest0(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test2.c";
        List<String> list = new LinkedList<String>();
        list.add(path);
        Assertions.assertEquals(4L,counter.countAnnotationLine(list));
    }

    @Test
    public void countCodeLineTest0(){
        String path = "D:\\IDEAProject\\word-count\\src\\test\\resources\\test2.c";
        List<String> list = new LinkedList<String>();
        list.add(path);
        Assertions.assertEquals(1L,counter.countCodeLine(list));
    }
}
