# src/main/resources 层说明

这一层保存模组元数据和运行时文本资源。

## 当前内容

- `mod.json`：告诉 Mindustry 这是一个隐藏的 Java 模组、入口类是谁、最低游戏版本是多少、显示名和简介是什么。
- `bundles/`：提供中英文文本。

## 实现方式

Mindustry 模组的真正装载入口不靠 Java manifest，而靠 `mod.json`。因此这里和 `src/main/java` 一样关键，缺一不可。

## 层级关系

- 上游会被 GitHub Release 工作流直接回写 `version` 字段。
- 下游被 `build/resources/main`、发布包和游戏内设置界面共同消费。
