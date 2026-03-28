# src/main/java/betterpolyai 层说明

这一层是主包源码，承载模组入口与更新检查。

## 当前文件职责

- `BetterPolyAiMod.java`：继承 `mindustry.mod.Mod`，在 `init()` 中初始化 `PolyAiFeature`，并在 `ClientLoadEvent` 后注册设置分类、应用更新检查默认值、触发首次检查。
- `GithubUpdateCheck.java`：封装 GitHub 最新版本检查逻辑，带有 6 小时节流、忽略版本、弹窗/Toast 两种提示方式，以及 API 失败后回退读取 `raw mod.json` 的兜底链路。
- `features/`：把真正的 Poly 建造 AI 与设置状态管理进一步拆出去。

## 实现方式

这个包负责“入口”和“横切能力”。入口类不直接实现建造 AI，而是把功能初始化委托给 `PolyAiFeature`；更新检查也被抽成独立工具类，避免入口类膨胀。

## 和其他层级的关系

- 上游使用 `src/main/resources/mod.json` 中的 `main` 字段把这里的 `BetterPolyAiMod` 设为模组入口。
- 下游由 `build/classes/java/main/betterpolyai` 编译并进入所有桌面/统一包。
