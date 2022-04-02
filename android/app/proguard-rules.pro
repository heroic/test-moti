# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/local/Cellar/android-sdk/24.3.3/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# React Native Core
-keep class com.facebook.react.turbomodule.** { *; }
-keep class com.facebook.hermes.unicode.** { *; }
-keep class com.facebook.jni.** { *; }

-assumenosideeffects class com.facebook.login.**

# Reanimated
-keep class com.swmansion.reanimated.** { *; }

# Installreferrer
-keepclassmembers class com.android.installreferrer.api.** {
  *;
}

# React Native SVG
-keep public class com.horcrux.svg.** {*;}

# Zendesk
# Guide Main Screen
-keep class zendesk.support.HelpCenterSettings { *; }
-keep class zendesk.support.HelpResponse { *; }
-keep class zendesk.support.ArticlesListResponse { *; }
-keep class zendesk.support.CategoryItem { *; }
-keep class zendesk.support.SectionItem { *; }
-keep class zendesk.support.ArticleItem { *; }
-keep class zendesk.support.SeeAllArticlesItem { *; }
-keep class zendesk.support.guide.HelpCenterActivity { *; }

# Guide Search Results
-keep class zendesk.support.guide.HelpSearchFragment { *; }
-keep class zendesk.support.ArticlesSearchResponse { *; }
-keep class zendesk.support.SearchArticle { *; }
-keep class zendesk.support.guide.HelpSearchRecyclerViewAdapter { *; }
-keep class zendesk.support.HelpCenterSearch { *; }
-keep class zendesk.support.Category { *; }
-keep class zendesk.support.Section { *; }
-keep class zendesk.support.Article { *; }

# Guide View Article
-keep class zendesk.support.guide.ArticleViewModel { *; }
-keep class zendesk.support.guide.ArticleConfiguration { *; }
-keep class zendesk.support.guide.ViewArticleActivity { *; }
-keep class zendesk.support.ArticleResponse { *; }
-keep class zendesk.support.ArticleVote { *; }
-keep class zendesk.support.ArticleVoteResponse { *; }
-keep class zendesk.support.ZendeskArticleVoteStorage { *; }
-keep class zendesk.support.AttachmentResponse { *; }
-keep class zendesk.support.HelpCenterAttachment { *; }

# Support Requests (Create, Update, List)
-keep class zendesk.support.request.** { *; }
-keep class zendesk.support.requestlist.** { *; }
-keep class zendesk.support.SupportSdkSettings { *; }
-keep class zendesk.support.Request { *; }
-keep class zendesk.support.CreateRequest { *; }
-keep class zendesk.support.Comment { *; }
-keep class zendesk.support.CommentResponse { *; }
-keep class zendesk.support.CommentsResponse { *; }
-keep class zendesk.support.EndUserComment { *; }
-keep class zendesk.support.ZendeskRequestStorage { *; }
-keep class zendesk.support.ZendeskRequestProvider { *; }
-keep class zendesk.support.CreateRequestWrapper { *; }
-keep class zendesk.support.UpdateRequestWrapper { *; }
-keep class zendesk.support.RequestsResponse { *; }
-keep class zendesk.support.RequestResponse { *; }

# Support Attachments
-keep class zendesk.support.UploadResponse { *; }
-keep class zendesk.support.UploadResponseWrapper { *; }
-keep class zendesk.support.ZendeskUploadProvider { *; }
-keep class zendesk.support.Attachment { *; }

# VisionCamera (CameraX)
-keep class androidx.camera.extensions.** { *; }

# Glide + WebP Decoder
-keep public class com.bumptech.glide.integration.webp.WebpImage { *; }
-keep public class com.bumptech.glide.integration.webp.WebpFrame { *; }
-keep public class com.bumptech.glide.integration.webp.WebpBitmapFactory { *; }
