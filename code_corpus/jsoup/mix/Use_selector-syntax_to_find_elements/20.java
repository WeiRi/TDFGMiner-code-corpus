package org.jsoup.test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test2QueryParser {
    String url = "https://dhlottery.co.kr/gameResult.do?method=byWin";
    Document doc = null; 
   
	@BeforeEach
	void setUp() throws Exception {
	    try {
	        doc = Jsoup.connect(url).get(); // -- 1. get����� URL�� �����ؼ� ������ ���� doc�� ��´�.zz
//	        ViewTree.makeViewTreeFile(doc, "test.txt");
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
	}

	@AfterEach
	void tearDown() throws Exception {
        doc = Jsoup.connect(url).get(); // -- 1. get����� URL�� �����ؼ� ������ ���� doc�� ��´�.zz

	}
	@Test
	void defualtIdQuerytest() {
		/*set query*/
		String selector = "#footer";
		/*set parser*/
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void defualtClassQuerytest() {
		/*set query*/
		String selector = ".footer";
		/*set parser*/
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void defualtattrQuerytest() {
		/*set query*/
		String selector = "[src]";
		/*set parser*/
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void defualtattrAllQuerytest() {
		/*set query*/
		String selector = "*";
		/*set parser*/
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void pseudoHasQuerytest() {
		/*set query*/
		String selector = ":has(div)";
		/*set parser*/
	    AbstractQueryParser parser = new TestNotIdQueryParser();
	    parser = new PseudoQueryParser(parser);
	    Jsoup.setQueryParser(parser);
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void pseudoNotQuerytest() {
		/*set query*/
		String selector = ":not(h2)";
		/*set parser*/
	    AbstractQueryParser parser = new TestNotIdQueryParser();
	    parser = new PseudoQueryParser(parser);
	    Jsoup.setQueryParser(parser);
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void testNotidQuerytest() {
		/*set query*/
		String selector = "#footer";
		/*set parser*/
	    AbstractQueryParser parser = new TestNotIdQueryParser();
	    parser = new TestIdQueryParser(parser);
	    Jsoup.setQueryParser(parser);
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void testNotclassQuerytest() {
		/*set query*/
		String selector = ".footer";
		/*set parser*/
	    AbstractQueryParser parser = new TestNotIdQueryParser();
	    parser = new TestClassQueryParser(parser);
	    Jsoup.setQueryParser(parser);
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void testStructualQuerytest() {
		/*set query*/
		String selector = ":first-child";
		/*set parser*/
	    AbstractQueryParser parser = new QueryParser();
	    parser = new StructuralQueryParser(parser);
	    Jsoup.setQueryParser(parser);
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void testNotClassIdQuerytest() {
		/*set query*/
		String selector = ".footer";
		/*set parser*/
	    AbstractQueryParser parser = new TestNotIdClassQueryParser();
	    parser = new TestIdQueryParser(parser);
	    parser = new TestClassQueryParser(parser);

	    Jsoup.setQueryParser(parser);
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void testNotClassIdQuerytest2() {
		/*set query*/
		String selector = ".logo";
		/*set parser*/
	    AbstractQueryParser parser = new TestNotIdClassQueryParser();
	    parser = new TestClassQueryParser(parser);
	    parser = new TestIdQueryParser(parser);

	    Jsoup.setQueryParser(parser);
	    /*running*/
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);

	}
	@Test
	void idQueryParser() {
	    String selector = ".footer";
	    Elements titles = doc.select(selector); // -- 2. doc���� selector�� ������ ������ Elemntes Ŭ������ ��´�.
	    assertNotNull(titles);
	}
}
