# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.jewel.labelview.LabelView {
    public *;
}
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 5
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/jewel/labelview/repack'
-flattenpackagehierarchy
-dontpreverify
