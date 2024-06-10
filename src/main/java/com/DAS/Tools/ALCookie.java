package com.DAS.Tools;
//Make by Bình An || AnLaVN || KatoVN

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ALCookie {

    private static HttpServletRequest req;
    private static HttpServletResponse resp;
    
    @Autowired
    public ALCookie(HttpServletRequest pReq, HttpServletResponse pResp) {
    	ALCookie.req = pReq;
    	ALCookie.resp = pResp;
    }

    /**Sử dụng phương thức này để thêm một cookie mới.
     * @param pName Là tên cookie cần thêm.
     * @param pValue Là giá trị của cookie cần thêm. Không vượt quá 4096 bytes.
     * @param pHours Là số giờ khả dụng của cookie.
     */
    public static final void add(String pName, String pValue, int pHours) {
        Cookie ck = new Cookie(pName, pValue);
        ck.setMaxAge(pHours * 60 * 60);
        ck.setPath("/");
        resp.addCookie(ck);
    }

    /**Sử dụng phương thức này để lấy giá trị của cookie.
     * @param pName Là tên cookie cần tìm.
     * @return Giá trị của cookie cần tìm nếu có. Null nếu không tìm thấy cookie hoặc không có cookie nào.
     */
    public static final String get(String pName) {
        Cookie[] cks = req.getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                if (ck.getName().equals(pName))  return ck.getValue();
            }
        }
        return null;
    }

    /**Sử dụng phương thức này để xoá cookie.
     * @param pName Là tên cookie cần xoá.
     * @return TRUE nếu xoá thành công. FALSE nếu không tìm thấy cookie hoặc không có cookie nào.
     */
    public static final boolean remove(String pName) {
        Cookie[] cks = req.getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                if (ck.getName().equals(pName)) {
                    add(pName, null, 0);
                    return true;
                }
            }
        }
        return false;
    }

}