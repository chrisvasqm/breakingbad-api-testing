package com.chrisvasqm.data;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
}
