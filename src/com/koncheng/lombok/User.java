package com.koncheng.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author chenyong01@baijiahulian.com
 * @version 2020-06-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
}
