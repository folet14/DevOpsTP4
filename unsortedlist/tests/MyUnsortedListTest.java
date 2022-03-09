import datastruct.EmptyListException;
import datastruct.MyUnsortedList;
import datastruct.UnsortedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyUnsortedListTest {

    private static final int DEFAULT_TIMEOUT = 2000;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testOf(){
        UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5,6,7,8);
        assertEquals("every iterable are inside",8,list.size());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testNotEqualsType(){
        UnsortedList<Integer> list = MyUnsortedList.of(1,2,3);
        String list2 = "MyUnsortedList.of()";
        assertFalse("wrong type test",list.equals(list2));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testNotEqualsLength() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        UnsortedList<Integer> list2 = MyUnsortedList.of(1);
        assertFalse("Different size test", list.equals(list2));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testNotEqualsValues() {
        UnsortedList<Integer> list = MyUnsortedList.of(0,1,2);
        UnsortedList<Integer> list2 = MyUnsortedList.of(0,2,1);
        assertFalse("Different values test", list.equals(list2));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testNotEqualsNullValues() {
        UnsortedList<Integer> list = MyUnsortedList.of(0,1,2);
        UnsortedList<Integer> list2 = MyUnsortedList.of(0,null,1);
        assertFalse("Different values test", list.equals(list2));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testEquals() {
        UnsortedList<Integer> list = MyUnsortedList.of(0,1,2);
        UnsortedList<Integer> list2 = MyUnsortedList.of(0,1,2);
        assertTrue("Same values test", list.equals(list2));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testAppendRemove() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(-3);
        list.append(15);
        list.append(12);
        list.append(43);
        assertEquals("size length equals append number", 4, list.size());
        assertEquals("get first element",43,(long) list.remove(3));
        assertEquals("get second element", 15, (long) list.remove(1));
        assertEquals("get third element", 12, (long) list.remove(1));
        assertEquals("get fourth element", -3, (long) list.remove(0));
        assertEquals("size length empty after remove", 0, list.size());
    }
@Test(timeout = DEFAULT_TIMEOUT)
    public void testSize(){
    UnsortedList<Integer> list = MyUnsortedList.of();
    assertEquals("size length when empty",0, list.size());

    list.append(2);
    assertEquals("size length after append",1, list.size());

    list.prepend(0);
    assertEquals("list size after prepend",2,list.size());

    list.insert(1,1);
    assertEquals("list size after insert", 3, list.size());

    list.pop();
    assertEquals("list size after pop",2,list.size());
    list.pop();
    assertEquals("size length after second pop",1, list.size());
    list.pop();
    assertEquals("size length after all pops",0, list.size());
    }


    @Test(timeout = DEFAULT_TIMEOUT)
    public void testIsEmpty() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue("empty list on creation", list.isEmpty());

        list.append(0);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        assertFalse("list not empty after append", list.isEmpty());
        list.popLast();
        list.popLast();
        list.popLast();
        list.popLast();
        list.popLast();
        assertTrue("list empty after popLast", list.isEmpty());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testPrependPop() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        list.prepend(0);
        assertEquals("list correctly prepend",4, list.size());
        assertEquals("pop first element",0,(long) list.pop());
        assertEquals("pop second element",1,(long) list.pop());
        assertEquals("pop third element",2,(long) list.pop());
        assertEquals("pop fourth element",3,(long) list.pop());
    }

    @Test(timeout = DEFAULT_TIMEOUT, expected = EmptyListException.class)
    public void testPopEmpty() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.pop();
    }

    @Test(timeout = DEFAULT_TIMEOUT, expected = EmptyListException.class)
    public void testPopLastEmpty() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.popLast();
    }

    @Test(timeout = DEFAULT_TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativeIndex() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        list.remove(-1);
    }

    @Test(timeout = DEFAULT_TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testRemoveBigIndex() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        list.remove(1);
    }

    @Test(timeout = DEFAULT_TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testInsertNegativeIndex() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        list.append(3);
        list.insert(2,-1);
    }

    @Test(timeout = DEFAULT_TIMEOUT, expected = IndexOutOfBoundsException.class)
    public void testInsertBigIndex() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        list.append(3);
        list.insert(2,3);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testInsertPopLast() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.insert(3,0);
        list.insert(0, 0);
        list.insert(2,1);
        list.insert(1,1);
        list.insert(4,4);
        assertEquals("list correctly inserted",5, list.size());
        assertEquals("pop fifth element",4,(long) list.popLast());
        assertEquals("pop fourth element",3,(long) list.popLast());
        assertEquals("pop third element",2,(long) list.popLast());
        assertEquals("pop second element",1,(long) list.popLast());
        assertEquals("pop first element",0,(long) list.popLast());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testToString(){
        UnsortedList<Integer> list = MyUnsortedList.of(1,2,3,4,5,6,7,8,9);
        list.toString();
    }
}
