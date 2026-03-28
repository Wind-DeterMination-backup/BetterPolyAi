# src/main 层说明

这一层对应 Gradle 主源集 `sourceSets.main`，也就是最终打进模组包的所有手写内容。

## 当前内容

- `java/` 保存业务代码。
- `resources/` 保存模组元数据与国际化资源。

## 实现方式

源码结构完全遵循标准 Gradle Java 项目约定，所以构建脚本几乎不需要自定义源集路径。

## 层级关系

- 上游是仓库作者手写内容。
- 下游分别进入 `build/classes/java/main` 与 `build/resources/main`。
