package com.imanage.service;

import com.imanage.exception.EmptyStackException;
import com.imanage.exception.FullStackException;
import com.imanage.exception.StackAlreadyPresentException;
import com.imanage.model.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomStackImpl implements CustomStack {




    private Stack stack;

    public void createStack(int totalSize) {
        if(stack != null) {
            throw new StackAlreadyPresentException();
        }
        stack = new Stack(totalSize);

    }


    @Override
    public void push(int val) {

        if(isFull()) {
            throw new FullStackException();
        }
        stack.incrementTop();
        stack.addValue(val);

    }

    @Override
    public int pop() {
        int val = peek();
        stack.decrementTop();
        return val;
    }

    @Override
    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getValue();
    }

    @Override
    public boolean isEmpty() {
        return stack.getTop() == -1;
    }

    @Override
    public boolean isFull() {
        return stack.getTop() == stack.getTotalSize()-1;
    }

    @Override
    public int size() {
        return stack.getTop()+1;
    }
}
