import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NasaAnalysis {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		File file = new File(System.getProperty("user.dir")+"/Data/"+"NASA");
		int chValue=0;
		while(chValue < 5){
			System.out.println();
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			System.out.println("1 )Http requests types");
			System.out.println("2 )Http responses types");
			System.out.println("3 )User access report");
			System.out.println("4 )Resources requested");
			System.out.println("5 )Exit Programe");
			System.out.println("+++++++++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println("Your Choice ?");
			chValue=input.nextInt();
			switch(chValue){
			case 1:
				try {
					long maxGetFreqnt=0; 
					long maxtPostFreqnt=0;
					Scanner scanner = new Scanner(file);
					while(scanner.hasNext()){
						String row = scanner.nextLine();
			            if(!row.isEmpty()){
			            	System.out.println(row);
			            	String[] line=row.split("- -");
			            	System.out.println("---------------**********---------------------");
			            	if(isIPAddress(line[0].trim())){
			            		System.out.println("The IP Address : "+line[0].trim());
			            	}else{
			            		System.out.println("The Domain Name :"+line[0].trim());
			            	}
			            	if(line.length >=2){
				            	if(line[1].trim().contains("GET")){
				            		maxGetFreqnt++;
				            	}
				               	if(line[1].trim().contains("POST")){
				            		maxtPostFreqnt++;
				            	}
			            	}
			               	if(maxGetFreqnt>maxtPostFreqnt){
			               		System.out.println("Type of GET request current count is "+maxGetFreqnt);
			               	}else{
			               		System.out.println("Type of POST request current count is "+maxtPostFreqnt);
			               	}
			               	System.out.println("---------------**********---------------------");
			            }
					}
		            if(maxGetFreqnt>maxtPostFreqnt){
	               		System.out.println("The most frequent type of GET request is "+maxGetFreqnt);
	               	}else{
	               		System.out.println("The most frequent type of POST request is "+maxtPostFreqnt);
	               	}
		            System.out.println("===============================================================");
	               	System.out.println();
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					long maxGetFreqnt=0; 
					long maxtPostFreqnt=0;
					Scanner scanner = new Scanner(file);
					while(scanner.hasNext()){
						String row = scanner.nextLine();
			            if(!row.isEmpty()){
			            	System.out.println(row);
			            	String[] line=row.split("- -");
			            	System.out.println("----------------**********--------------------");
			            	if(isIPAddress(line[0].trim())){
			            		System.out.println("The IP Address : "+line[0].trim());
			            	}else{
			            		System.out.println("The Domain Name :"+line[0].trim());
			            	}
			            	if(line.length >=2){
				            	if(line[1].trim().contains("GET")){
				            		maxGetFreqnt++;
				            	}
				               	if(line[1].trim().contains("POST")){
				            		maxtPostFreqnt++;
				            	}
			            	}
			               	if(maxGetFreqnt>maxtPostFreqnt){
			               		System.out.println("Type of GET request current count is "+maxGetFreqnt);
			               	}else{
			               		System.out.println("Type of POST request current count is "+maxtPostFreqnt);
			               	}
			               	System.out.println("----------------*********--------------");
			            	for(int i=1;i<line.length;i++){
			            		String[] subStr=line[i].split(" ");
			            		for(int j=0;j<subStr.length;j++){
			            			System.out.println(j+":"+subStr[j]);
			            		}
			            	}
			            }
					}
		            if(maxGetFreqnt>maxtPostFreqnt){
	               		System.out.println("The most frequent type of GET request is "+maxGetFreqnt);
	               	}else{
	               		System.out.println("The most frequent type of POST request is "+maxtPostFreqnt);
	               	}
		            System.out.println("===============================================================");
	               	System.out.println();
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				String searchAddrss="";
				int requestCount = 0;
				int responseCount =0;
				System.out.println("User Access Report:");
				System.out.println("Please Enter IP Address OR Web Address:");
				searchAddrss= input.next();
				try {
					long maxGetFreqnt=0; 
					long maxtPostFreqnt=0;
					Scanner scanner = new Scanner(file);
					while(scanner.hasNext()){
						String row = scanner.nextLine();
			            if(!row.isEmpty()){
			            	if(row.contains(searchAddrss)){
				            	System.out.println(row);
				            	String[] line=row.split("- -");
				            	System.out.println();
				            	if(isIPAddress(line[0].trim())){
				            		System.out.println("IP Address : "+line[0].trim());
				            	}else{
				            		System.out.println("Domain Name :"+line[0].trim());
				            	}
				            	if(line.length >=2){
					            	if(line[1].trim().contains("GET")){
					            		maxGetFreqnt++;
					            	}
					               	if(line[1].trim().contains("POST")){
					            		maxtPostFreqnt++;
					            	}
				            	}
				               	System.out.println("Type of GET request current count is "+maxGetFreqnt);
				               	System.out.println("Type of POST request current count is "+maxtPostFreqnt);
				               	System.out.println("------------------------------------");
				            	for(int i=1;i<line.length;i++){
				            		String[] subStr=line[i].split(" ");
				            		for(int j=0;j<subStr.length;j++){
				            			System.out.println(j+":"+subStr[j]);
				            		}
				            	}
			            	}
			            }
					}
		            if(maxGetFreqnt>maxtPostFreqnt){
	               		System.out.println("The most frequent type of GET request is "+maxGetFreqnt);
	               	}else{
	               		System.out.println("The most frequent type of POST request is "+maxtPostFreqnt);
	               	}
		            System.out.println("===============================================================");
	               	System.out.println();
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println();
				long fileCount=0;
				try {
					Scanner scanner = new Scanner(file);
					while(scanner.hasNext()){
						String row = scanner.nextLine();
			            if(!row.isEmpty()){
			            	String[] line=row.split("- -");			            	System.out.println("------------------------------------");
			            	if(isIPAddress(line[0].trim())){
			            		System.out.println("IP Address : "+line[0].trim());
			            	}else{
			            		System.out.println("Domain Name :"+line[0].trim());
			            	}
			               	System.out.println("------------------------------------");
			            	for(int i=1;i<line.length;i++){
			            		String[] subStr=line[i].split(" ");
			            		for(int j=0;j<subStr.length;j++){
			            			if(j == 4 && (subStr[j].contains(".gif") || subStr[j].contains(".text") || subStr[j].contains(".text") || subStr[j].contains(".")) ){
			            				fileCount++;
			            				System.out.println("Count "+fileCount+":"+subStr[j]);
			            			}
			            		}
			            	}
			            }
					}
					System.out.println("===============================================================");
					System.out.println("The total file requested/accessed counts : "+fileCount);
		            System.out.println("===============================================================");
	               	System.out.println();
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Exited the Programe!!!");
			}
	}
		}
    public static boolean isIPAddress(String ip){
    	try{
	        Pattern pattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
	        Matcher matcher = pattern.matcher(ip);
	        return matcher.find();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return false;
    }		
		
}

