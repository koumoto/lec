package jp.ac.kic.st.s15018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookListBean {
	private List<BookBean> list = new ArrayList<BookBean>(5000);

	public void add(BookBean bookBean){
		this.list.add(bookBean);
	}

	public BookBean get(int i){
		return this.list.get(i);
	}

	public int getSize(){
		return this.list.size();
	}

	public void dummy(){
		this.add(new BookBean("新ｱﾄﾞﾊﾞﾝｽﾄﾘﾌｧﾚﾝｽ DB2 逆引きﾘﾌｧﾚﾝｽ","太田一郎",
		"9784774120386",2005));
		this.add(new BookBean("SQL ｽｰﾊﾟｰﾘﾌｧﾚﾝｽ","堀江美彦","9784798007588",2005));
		this.add(new BookBean("情報科学ｰ情報ﾘﾃﾗｼｰとﾌﾟﾚｾﾞﾝﾃｰｼｮﾝ 第 3 版","平田浩一",
		"9784873619934",2005));
		this.add(new BookBean("Java ｻｰﾌﾞﾚｯﾄﾌﾟﾛｸﾞﾗﾐﾝｸﾞ","ハンター，ジェイソン",
		"9784873110714",2004));
		this.add(new BookBean("Amazon Hacks","ボシュ，ポール","9784873111810",2004));
	}

	public List<BookBean> readDataFromCSV(String path) throws IOException{
		String line;
		String[] bookData;
		File file = new File(path); // CSVデータファイル
		BufferedReader br = new BufferedReader(new FileReader(file));
		//int i = 0;
		while ((line = br.readLine()) != null) {
			bookData = line.split(",");
			String name = bookData[0];
			String author = bookData[2];
			String isbn = bookData[1];
			int publishYear = 2000;
			try{
				publishYear = Integer.parseInt(bookData[3]);
			}catch(Exception e){
				publishYear = 2000;
			}
			BookBean bookBean = new BookBean(name, author, isbn, publishYear);
			list.add(bookBean);
			//System.out.println(i);
			//i++;

		}
		if(br!=null){
			br.close();
		}
		return list;
	}

	public BookListBean selectData(BookBean bookBean){
		BookListBean retlist = new BookListBean();
		try{
			retlist.add(list.get(list.indexOf(bookBean)));
		}catch (Exception e){
			return null;
		}
		return retlist;
	}

	public BookListBean selectAll(){
		return this;
	}
}