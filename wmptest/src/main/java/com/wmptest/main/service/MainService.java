package com.wmptest.main.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.wmptest.main.vo.MainVo;

@Service
public class MainService {
	
	/**
	 * ���ڿ� ���
	 *  - ���� ���� ����
	 *  - �������� ����
	 *  - ���� ���� ������ ��ġ
	 *  - ��¹��� ������ ���� ��, ������ �и�
	 * @param vo
	 * @return
	 */
	public MainVo printOut(MainVo vo) {
		
		String rawHtmlData = null;
		String[] eng = null;
		String[] digit = null;
		
		StringBuilder sb = new StringBuilder();
		
		// �������� �о����
		rawHtmlData = getRawHtml(vo.getUrl());
		
		//���Ÿ�� Ȯ���Ͽ� html �±� ����
		if("H".equals(vo.getType())) {
			rawHtmlData = removeHtmlTag(rawHtmlData);
		}
		
		// ���� ���� ����, ����
		eng = extractEng(rawHtmlData);
		digit = extractDig(rawHtmlData);
		
		if(eng.length==0) {
			if(digit.length>0) {
				sb.append(digit.toString());
			}
			
		}else {
			
			if(digit.length==0) {
				sb.append(digit.toString());
			}else {
				
				for(int i=0; i<eng.length; i++) {
					sb.append(eng[i]);
					
					if(i<digit.length && digit[i] != null) {
						sb.append(digit[i]);
					}
				}
				
			}
			
		}
		
		vo.setHtml(sb.toString());
		vo = setResultBySize(vo);
		
		return vo;
	}
	
	// ��¹��� ������ ������ ����迭�� ����
	public MainVo setResultBySize(MainVo vo) {
		
		int size = vo.getPrintGroupSize();
		String htmlText = vo.getHtml();
		
	    int arrayLength = (int) Math.ceil(((htmlText.length() / (double)size)));
	    String[] result = new String[arrayLength];

	    int j = 0;
	    int lastIndex = result.length - 1;
	    for (int i = 0; i < lastIndex; i++) {
	        result[i] = htmlText.substring(j, j + size);
	        j += size;
	    }
	    
	    if(htmlText.substring(j).length()==size) {
	    	result[lastIndex] = htmlText.substring(j);
	    	vo.setRemainStr("");
	    }else {
	    	vo.setRemainStr(htmlText.substring(j));
	    }
	    vo.setResult(result);

	    return vo;
	}
	
	// html �±� ����
	public String removeHtmlTag(String htmlDocStr) {
		return htmlDocStr.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}

	// ������ ������ ���� ȣ��
	public String[] extractEng(String htmlDocStr) {
		return sortEng(htmlDocStr.replaceAll("[^a-zA-Z]", "").split(""));
	}
	
	// ���� ������ ���� ȣ��
	public String[] extractDig(String htmlDocStr) {
		return sort(htmlDocStr.replaceAll("[^0-9]", "").split(""));
	}
	
	// ������ ���� ������
	public String[] sortEng(String[] data) {
		
		Arrays.sort(data, new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2) {
				// ��ҹ��� �����ϰ� ���ؼ� ������ �������
				return s1.compareToIgnoreCase(s2) == 0 ? s1.compareTo(s2) : s1.compareToIgnoreCase(s2);
			}
			
		});
		
		return data;
		
	}
	
	// �������� ����ó��
	public String[] sort(String[] data) {
		Arrays.sort(data);
		return data;
	}
	
	// �������� �ҽ� ��������
	public String getRawHtml(String readUrl) {
	    URL url;
	    HttpURLConnection conn;
	    BufferedReader br;
	    String line;
	    String result = null;
	    
	    try {
	        url = new URL(readUrl);
	        
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        
	        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        while ((line = br.readLine()) != null) {
	            result += line + "\n";
	        }
	        
	        br.close();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
}
