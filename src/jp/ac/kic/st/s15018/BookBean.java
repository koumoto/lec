package jp.ac.kic.st.s15018;

public class BookBean {
	private String name;
	private String author;
	private String isbn;
	private int publishYear;

	public BookBean(){ //デフォルトの引数なしのコンストラクタ
		this.name = "";
		this.author = "";
		this.isbn = "";
		this.publishYear = 0;
	}

	public BookBean(String name, String author, String isbn, int publishYear){
		this.name = name;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
	}

	public String getName(){
		return this.name;
	}

	public String getAuthor(){
		return this.author;
	}

	public String getIsbn(){
		return this.isbn;
	}

	public int getPublishYear(){
		return this.publishYear;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public void setIsbn(String isbn){
		this.isbn = isbn;
	}

	public void setPublishYear(int publishYear){
		this.publishYear = publishYear;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof BookBean)) return false;
		BookBean bean = (BookBean) obj;
		if(this.getName().equals(bean.getName())) return true;
		return false;
	}

	@Override
	public int hashCode(){
		int retval = this.name.hashCode();
		retval += this.author.hashCode();
		retval += this.isbn.hashCode();
		retval += this.publishYear * 51;
		return retval;
	}

}
