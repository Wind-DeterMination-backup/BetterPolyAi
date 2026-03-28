# dist 层说明

这一层是仓库内额外保留的分发目录，目前未被 Git 跟踪。

## 当前内容

- `BetterPolyAi.zip`
- `BetterPolyAi.jar`

## 读到的细节

- 两个文件体积都为 23406 字节，远大于 `build/libs` 中同名角色的桌面包。
- 两个包的内部条目一致，且都同时包含 `.class`、`bundles`、`mod.json` 和 `classes.dex`。
- 这种结构更接近“统一兼容桌面与 Android 的合并分发包”，而不是 `build.gradle` 当前 `jar` / `jarDesktop` 任务直接生成的结果。

## 实现方式与推断

从当前工作区看，`dist/` 很可能不是这次 `build.gradle` 直接复制出来的最新物，而是某次外部打包、CI 产物回收、或手工整理过的最终发布目录。因为 `build/libs/betterPolyAi.zip` 与 `build/libs/betterPolyAi.jar` 当前都不带 `classes.dex`。

## 和其他层级的关系

- 与 `build/release-stage` 的结构特征更相近。
- 面向最终用户，而不是编译器。
