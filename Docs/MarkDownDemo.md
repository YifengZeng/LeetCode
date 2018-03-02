>reference: http://www.cnblogs.com/fanzhidongyzby/p/6637084.html
https://zh.wikipedia.org/wiki/Markdown

---------------------------------------

1. 安装Atom

下载安装Atom：https://atom.io/

---

2. 增强预览(markdown-preview-plus)

支持预览实时渲染。(Ctrl + Shift + M)

支持Latex公式。(Ctrl + Shift + X)

\[
e ^ {i\pi} + 1 = 0
\]

e<sup>2</sup>

x<sub>0</sub>

~~Strikethrough~~

(C)Copyright

--

(R)

(TM)

(P)

+-

' '

'' ''

---

3. 同步滚动(markdown-scroll-sync) (好象有问题)

#一级标题

- 一
- 二
  - 2.1
  - 2.2
    - 2.2.1
    - 2.2.2
      - 2.2.2.1
      - 2.2.2.2
- 三



##二级标题 水平分割线

* * *
***
*****
- - -
---------------------------------------
---

###三级标题 强调

*强调（斜体）*
_强调（斜体)_

**加重强调**

又或者以制表符或至少四个空格缩进的行，例如：

    第一行代码
    第二行代码
    第三行代码

####四级标题 引用

> 这一整段的内容都会作为一个HTML的引用元素。
引用元素是会自动优化排版的（reflowable，可回流）。
你可以任意地将引用的内容包含进来，然后所有这些都会
被解析成为单独一个引用元素。

> 这是一个引用。这是第一行
这是第二行。
>> 这是一个嵌套的引用。这是第一行。
这是第二行
>
> 外层引用的第三行。前面需要一个视觉上的空行表示内层嵌套的结束，空行前面的>可以有可以没有。

---

4. 代码增强(language-markdown)
```Java
public String reverseWords(String str) {
        char[] s str.toCharArray();


        if (s == null || s.length() <= 1) {
            return s;
        }

        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
```

---

5. 图片粘贴(markdown-image-paste)

截图到剪切板，Ctrl + V就可以直接贴
![](186.png)

---

6. 表格编辑(markdown-table-editor)

| Name   | Age | Weight |
| ------ | --- | ------ |
| Yifeng | 30  | 100    |
|        |     |        |
