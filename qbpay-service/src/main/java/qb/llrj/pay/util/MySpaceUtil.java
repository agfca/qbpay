package qb.llrj.pay.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

public class MySpaceUtil {

    /***/
    public static String FILTER_STR = "http://";

    public static String FILTER_STRS = "https://";

    public static String URL_FOR = "http://qb.com/";

    public static String PANNTER = "(?i)https?://[^\\s\\u4e00-\\u9fa5]+";

    public static Logger logger = Logger.getLogger(MySpaceUtil.class);

    @SuppressWarnings("deprecation")
    public static String timeCompare(Date now, Date date1) {
        java.util.Date date = new java.util.Date(date1.getTime());
        long l = now.getTime() - date.getTime();
        long m = now.getMonth() - date.getMonth();
        long day = now.getDate() - date.getDate();
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long y = now.getYear() - date.getYear();
        String ret = "";
        if (y > 0)//  
            ret += (date.getYear() + 1900) + "-";
        if (day > 0 || y > 0 || m > 0) {//  
            if (date.getMonth() + 1 < 10)
                ret += "0";
            ret += (date.getMonth() + 1) + "-";
            if (date.getDate() < 10)
                ret += "0";
            ret += date.getDate() + " ";
        }
        if (hour > 0 || day > 0 || y > 0 || m > 0) {//  
            if (date.getHours() < 10)
                ret += "0";
            ret += date.getHours() + ":";
            if (date.getMinutes() < 10)
                ret += "0";
            ret += date.getMinutes();
        }
        if (y == 0 && (day * 24 + hour) == 0 && min != 0)
            ret = min + " ";
        if (y == 0 && (day * 24 + hour) == 0 && min == 0)
            ret = "1 ";
        return ret;
    }

    /**
     * 
     * @param input
     *            String.
     */
    public static String toDBC(String input) {
        if (!StringUtils.hasLength(input))
            return "";
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);

            }
        }
        String returnString = new String(c);
        return returnString;
    }

    /**
     * 
     * @param str
     * @return
     */
    public static Long stringToLong(String str) {
        if (str == null || "".equals(str))
            return 0L;
        return new Long(str);
    }

    /**
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean compareDate(String date1, String date2) {
        Boolean result = true;
        if (stringToLong(date1) != 0 && stringToLong(date2) != 0) {
            Long temp = stringToLong(date1) - stringToLong(date2);
            if (temp < 0) {
                result = false;
            }
        }
        return result;
    }

    public static Boolean unifiedCodeCheck(String IDNumber){
    	 String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                 "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
    	 if (IDNumber == null || "".equals(IDNumber)) {
             return false;
         }
    	 boolean matches = IDNumber.matches(regularExpression);
    	 return matches;
    }
    /**
     */
    public static String view(String str) {

        if (str == null) {
            return str;
        }
        str = str.replace("\n", "<br>");

        return str;
    }

    /**
     * <p>
     * Constants.STRING_NUM
     * </p>
     */
    // public static boolean checkAndSubContent(StringBuffer content) {
    // boolean result = false;
    // int length = content.length();
    // if (length > Constants.STRING_NUM) {
    // content.delete(Constants.STRING_NUM, length);
    // result = true;
    // }
    //
    // return result;
    // }

    public static String packageStrByList(List<Long> list) {
        if (list == null)
            return "";
        String feedIds = "";
        if (list != null && list.size() > 0) {
            StringBuffer feedId = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null)
                    feedId.append(list.get(i).toString()).append(",");
            }
            feedIds = feedId.toString();
            if (feedIds.endsWith(","))
                feedIds = feedIds.substring(0, feedIds.length() - 1);
        }
        return feedIds;
    }

    // public static Map<String, Object[]>
    // packageStrIdByMap(List<HashMap<String, Object>> list, int pagesize) {
    // if (list == null)
    // return null;
    // List<Long> medical = new ArrayList<Long>();
    // List<Long> cedical = new ArrayList<Long>();
    // List<HashMap<String, Object>> subList = new ArrayList<HashMap<String,
    // Object>>();
    // for (int i = 0; i < list.size() && i < pagesize; i++) {
    // if (list.get(i) != null) {
    // String p = (String) list.get(i).get("poClass");
    // if (p.equals("MedicalProduct")) {
    // medical.add((Long) list.get(i).get("id"));
    // } else {
    // cedical.add((Long) list.get(i).get("id"));
    // }
    // }
    // subList.add(list.get(i));
    // }
    // list.removeAll(subList);
    // Map<String, Object[]> listS = new HashMap<String, Object[]>();
    // if (medical.size() > 0) {
    // listS.put(MblogType.PRODUCT.getTypeCode(), medical.toArray());
    // }
    // if (cedical.size() > 0) {
    // listS.put(MblogType.COllECTPRODUCT.getTypeCode(), cedical.toArray());
    // }
    // return listS;
    // }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List packageStrByPageSize(String feedIds, int pagesize) {
        if (feedIds == null || (feedIds != null && feedIds.equals("")))
            return null;
        Long[] top = null;
        StringBuffer feed = new StringBuffer();

        List listStr = new ArrayList();
        if (feedIds.split(",").length > pagesize) {
            top = new Long[20];
            String[] strArr = feedIds.split(",");
            for (int i = 0; i < pagesize && i < strArr.length; i++) {
                if (strArr[i] != null && !"".equals(strArr[i]))
                    top[i] = Long.parseLong(strArr[i]);
            }
            feedIds = "";
            for (int i = pagesize; i < strArr.length; i++) {
                feed.append(strArr[i]).append(",");
            }
            if (feed.length() > 0)
                feedIds = feed.toString();
        } else {
            String[] strArr = feedIds.split(",");
            top = new Long[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] != null && !"".equals(strArr[i]))
                    top[i] = Long.parseLong(strArr[i]);
            }
            feedIds = "";
        }
        listStr.add(top);
        listStr.add(feedIds);
        return listStr;
    }

    public static String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(date);
        return str;
    }

    public static Date stringToDate(String dateS) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(dateS);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date stringToDate(String dateS,String formats) {
    	 DateFormat format =null;
    	
        try {
        	if(formats==null||formats.length()==0){
        		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	}
        	else{
        		format = new SimpleDateFormat(formats);
        	}
            Date date = format.parse(dateS);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String repalceContent(String content) {
        content = content.replaceAll(" {2,}", "    ");
        content = content.replaceAll("@", ".");
        content = content.replaceAll("(\r?\n(\\s*\r?\n)+)", "\r\n");
        return content;
    }

    public static String filterQuotes(String str) {
        str = str.replaceAll("\"", "");
        return str;
    }

    // public static String cutString(String str, int count) {
    // if (str != null && str.getBytes().length > count * 2)
    // str = str.substring(0, count) + Constants.STRFILR;
    // return str;
    // }
    //
    // public static List<MblogDto> sortList(List<MblogDto> list1, List<Long>
    // list2) {
    // if (list1 == null || list2 == null)
    // return list1;
    // List<MblogDto> list = new ArrayList<MblogDto>();
    // for (int i = 0; i < list2.size(); i++) {
    // for (int j = 0; j < list1.size(); j++) {
    // Long o = list1.get(j).getId();
    // if (list2.get(i).equals(o)) {
    // list.add(list1.get(j));
    // break;
    // }
    // }
    // }
    // return list;
    // }
    //
    // public static MblogDto doCheck(Map<String, Object> map) {
    // MblogDto mblogsDto = new MblogDto();
    // mblogsDto.setId(((BigDecimal) map.get("id")).longValue());
    // mblogsDto.setUserName((String) map.get("nick_name"));
    // mblogsDto.setContent((String) map.get("content"));
    // String time = "";
    // try {
    // time = MySpaceUtil.timeCompare(new Date(), ((TIMESTAMP)
    // map.get("pub_date")).dateValue());
    // } catch (Exception e) {
    // e.getStackTrace();
    // }
    // mblogsDto.setPubDate(time);
    // if ((String) map.get("picture") != null && !((String)
    // map.get("picture")).equals("0"))
    // mblogsDto.setSmallPicture((String) map.get("picture"));
    // if (map.get("space_id") != null)
    // mblogsDto.setSpaceId(((BigDecimal) map.get("space_id")).longValue());
    // if (map.get("info_type") != null) {
    // mblogsDto.setInfoType((String) map.get("info_type"));
    // mblogsDto.setInfoTitle(Constants.getInfoTitle((String)
    // mblogsDto.getInfoType()));
    // }
    // if (map.get("MORE_FLAG") != null)
    // mblogsDto.setMoreFlag(((BigDecimal) map.get("MORE_FLAG")).longValue());
    // if (map.get("publisher_id") != null)
    // mblogsDto.setPublisherId(((BigDecimal)
    // map.get("publisher_id")).longValue());
    // if (map.get("ref_id") != null)
    // mblogsDto.setRefId(((BigDecimal) map.get("ref_id")).longValue());
    // if (map.get("title") != null)
    // mblogsDto.setTitle((String) map.get("title"));
    // if (map.get("type") != null)
    // mblogsDto.setType(((BigDecimal) map.get("type")).longValue());
    // if (map.get("transmit_count") != null)
    // mblogsDto.setTransmitCount(((BigDecimal)
    // map.get("transmit_count")).longValue());
    // if (map.get("comment_count") != null)
    // mblogsDto.setCommentCount(((BigDecimal)
    // map.get("comment_count")).longValue());
    // if (map.get("zone") != null)
    // mblogsDto.setZone((String) map.get("zone"));
    // if (map.get("SMALL_PICTURE") != null && (String) map.get("BIG_PICTURE")
    // != null) {
    // mblogsDto.setSmallPic((String) map.get("SMALL_PICTURE"));
    // mblogsDto.setBigPicture((String) map.get("BIG_PICTURE"));
    // }
    // if (map.get("MID_PICTURE") != null) {
    // mblogsDto.setMidPicture((String) map.get("MID_PICTURE"));
    // }
    // return mblogsDto;
    // }

    // /**
    // *
    // * @param mblog
    // * @return
    // */
    // public static boolean checkHasUser(Mblog mblog) {
    // return mblog.getPublisherId() != null &&
    // !mblog.getPublisherId().equals(0L);
    // }
    //
    // public static String convertDecimalToBinary(int value) {
    // return Integer.toHexString(value);
    // }
    //
    // /**
    // *
    // * @return
    // */
    // public static boolean isLoadedSpecialSpace() {
    // return !(BIDLINKZF_USER == null || BIDLINKGC_USER == null ||
    // BIDLINKQT_USER == null);
    // }

    final static char[] digits = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    /**
     * 
     * @param i
     * @param radix
     * @return
     */
    public static String toUnsignedString(long i, long radix) {
        String tmp = "";
        do {
            long lf = 0;
            if (i < radix) {
                tmp = digits[(int) i] + tmp;
                break;
            }
            lf = i % radix;
            tmp = digits[(int) lf] + tmp;
            i = i / radix;
        } while (i != 0);
        return tmp;
    }

    /**
     * 
     * @param i
     * @param radix
     * @return
     */
    public static long toTen(String un) {
        long ten = 0;
        char[] tens = un.toCharArray();
        int len = tens.length;
        if ((len - 1) == 0) {
            for (int i = 0; i < digits.length; i++) {
                if (tens[0] == digits[i])
                    return i;
            }
        }
        do {
            int i = 0;
            for (; i < digits.length; i++) {
                char a = tens[tens.length - len];
                if ((a + "").equals(digits[i] + ""))
                    break;
            }
            int j = 0;
            if (len - 1 >= 0) {
                j = len - 1;
                if (i == 0)
                    ten += 0;
                else
                    ten += i * Math.pow(52, j);
            }
            len--;
        } while (len > 0);
        return ten + 1;
    }

    /**
     * 
     * @param content
     * @return
     */
    public static ArrayList<String> findUrl(String content) {
        String regUrl = PANNTER;
        Pattern p = Pattern.compile(regUrl);
        Matcher m = p.matcher(content);
        ArrayList<String> str = new ArrayList<String>();
        while (m.find()) {// Ϊtrue
            String url = m.group();
            if (!str.contains(url))
                str.add(url);
            logger.info("url group :" + m.group());
        }
        return str;
    }

    public static String replaceIndexStr(String contentForPage, String old, String newString) {
        contentForPage += " ";
        String regUrl = old + "[\\s|\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regUrl);
        Matcher m = p.matcher(contentForPage);
        while (m.find()) {// Ϊtrue
            int index = contentForPage.indexOf(old);
            StringBuffer bf = new StringBuffer(contentForPage).delete(index, index + old.length());
            bf.insert(index, newString);
            contentForPage = bf.toString();
        }
        return contentForPage;
    }

    /**
     * 
     * @param content
     * @return
     */
    public static ArrayList<String> findShortUrlKey(String content) {
        String regUrl = PANNTER;
        Pattern p = Pattern.compile(regUrl);
        Matcher m = p.matcher(content);
        ArrayList<String> str = new ArrayList<String>();
        while (m.find()) {// Ϊtrue
            String url = m.group();
            String key = url.substring(URL_FOR.length(), url.length());
            str.add(key);
            logger.info("url group :" + m.group());
        }
        return str;
    }

    public static String addAtoHttp(String content, String shortUrl, String url) {
        String html = "<a href='" + url + "' target='blank'>" + shortUrl + "</a>";
        content = content.replace(shortUrl, html);
        return content;
    }

    private static String dateFormat(Date d, String formatStr) {
        return (new java.text.SimpleDateFormat(formatStr).format(d));
    }

    /**
     */
    public static String toDate(Date d, String format, String hqlFormat) {
        StringBuffer bf = new StringBuffer();
        bf.append("to_date('");
        bf.append(dateFormat(d, format));
        bf.append("','");
        bf.append(hqlFormat);
        bf.append("')");
        return bf.toString();
    }

    
    
    private static boolean containAt(int money){
  	  if(money<100){
  		 return true;
  	  }
  	  String monS = money+"";
  	  char[] monc =  monS.toCharArray();
  	  if('0'==monc[monc.length-1])
  		return true;
  	   return false;
  	}
    
    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
         	if(chr<48 || chr>57)
               return false;
         }
       return true;
    }  
    
    public static boolean isMoney(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            System.out.println(i+":"+chr);
            if(chr!=46){
            	if(chr<48 || chr>57)
                   return false;
            } 
        }
       return true;
    }     
    
    public static void main(String[] a) {
    	int aaa = 10;
    	System.out.print(containAt(aaa));
        String str = "HTTP://www.abceee.com/http://www.99pto.com/dingdan/userOrder.php?action=all http://www.a3ddd.com/ http://www.ad2dd.com/ ";
        String regUrl = "(?i)https?://[^\\s\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regUrl);
        Matcher m = p.matcher(str);
        while (m.find()) {// Ϊtrue
            System.out.println("Group: " + m.group());//
        }
        System.out.println(str.contains("(?i)https?://+"));
        System.out.println(str.replaceAll("((?i)https?://[^\\s\\u4e00-\\u9fa5]+)", "dddd"));
        System.out.println(toUnsignedString(65535, 8));
        System.out.println(toUnsignedString(65535, 32));
        System.out.println(toUnsignedString(51, 52));
        System.out.println(toTen("Aac"));
        System.out.println(toUnsignedString(toTen("Qsdf"), 52));// 7λ fHKRMx
        String content = "http://www.baidu.com http://www.baidu.comsdfsdfhttp://www.baidu.comsdfsdf3333";
        content = replaceIndexStr(content, "http://www.baidu.com", "http://ebnew.com/baaaaY");
        System.out.println(content);
        content = replaceIndexStr(content, "http://www.baidu.comsdfsdf", "http://ebnew.com/baaaaZ");
        System.out.println(content);
        content = replaceIndexStr(content, "http://www.baidu.comsdfsdf3333", "http://ebnew.com/baaaba");
        System.out.println(content);
        
    }
}
