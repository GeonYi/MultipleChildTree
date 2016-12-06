## **Multi Child Tree**

#### description

it's implement just tree struct.

tree is set of node.  *tree* consists of *parent*, *child*.

root has just 2 child in java(as BinaryTree API).  so, i implement tree will have many child.

in java,
~~~
  root  -> Child01 -> child011
                   -> child012
        -> Child02 -> child021
                   -> child022
~~~

child01 is parent node of child011, child012 and child of root.

it's impossible has many child. like this,

~~~
  root  -> Child01 -> child011
                   -> child012
                   -> child013
        -> Child02 -> child021
                   -> child022
~~~

And, i wanted each node are runnable.  but, doesn't impl, just declare interface.
if using this code and need running of node, than send mail. Or need more function, also send mail.

#### using

In this project, exist two major(include external API) class, which *MultiChildTree.class* and *MultiChildTreeHelper.class*.

The *MultiChildTree.class* is implementation of *Tree* interface.

Using like this,
```java
    MultiChildTree<String> tree = new MultiChildTree<>();

    Node<String> tn1 = tree.addRoot("root");
    Node tn2 = tree.addNode("sec", tn1);

    System.out.println("root :" + tree.getRoot().getData());
    System.out.println("sec  :" + tn2.getData());
    System.out.println("parent of sec:" + tn2.getParent().getData());
```

The *MultiChildTreeHelper.class* is decorator class of *MultiChildTree.class*.

Using like this,
```java
    MultiChildTreeHelper<String> th = new MultiChildTreeHelper<>(new MultiChildTree<>());

    UUID rootId = th.addRoot("root");
    UUID secId  = th.addNode("sec", rootId);

    System.out.println("root / uuid:" + rootId + ", data:" + th.findByKey(rootId).getData());
    System.out.println("sec  / uuid:" + secId  + ", data:" + th.findByKey(secId).getData());
```


if want more info and more api then send email(:yigeon84@gmail.com)























