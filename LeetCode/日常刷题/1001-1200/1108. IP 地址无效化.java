class Solution {
    public String defangIPaddr(String address) {
        // 返回这个 IP 地址的无效化版本
        // 用 "[.]" 代替了每个 "."
        // 朴素解法
        // return method1(address);
        // API
        return method2(address);
    }


    public String method2(String address) {
        return address.replace(".", "[.]");
    }

    public String method1(String address) {
        // 返回这个 IP 地址的无效化版本
        // 用 "[.]" 代替了每个 "."
        StringBuilder res = new StringBuilder();
            for (char c : address.toCharArray())  {
                if (c != '.') res.append(c);
                else {
                    res.append('[');
                    res.append(c);
                    res.append(']');
                }
            }
            return res.toString();
    }

}