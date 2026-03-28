# src/main/java 层说明

这一层保存所有 Java 业务源码。

## 当前内容

- 只有一个包 `betterpolyai/`，表明命名空间集中，没有多模块或多子系统拆分。

## 实现方式

项目使用标准 Java 包结构，而不是脚本式或混合语言实现。结合 `build.gradle` 的 `compileOnly "MindustryJitpack:core"`，可知这里的源码完全依赖 Mindustry/Arc API 编译。

## 层级关系

- 上游来自开发者直接编写。
- 下游编译到 `build/classes/java/main`。
