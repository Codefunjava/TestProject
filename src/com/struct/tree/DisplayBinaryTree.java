package com.struct.tree;

import javax.swing.JApplet;

public class DisplayBinaryTree extends JApplet{
	public DisplayBinaryTree(){
		add(new TreeControl(new BinaryTree<Integer>()));
	}
}
