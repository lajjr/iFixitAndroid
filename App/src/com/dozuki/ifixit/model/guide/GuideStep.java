package com.dozuki.ifixit.model.guide;

import com.dozuki.ifixit.model.Embed;
import com.dozuki.ifixit.model.Image;
import com.dozuki.ifixit.model.Video;

import java.io.Serializable;
import java.util.ArrayList;

public class GuideStep implements Serializable {
   private static final long serialVersionUID = 2884598684003517264L;

   /**
    * Guide that this step originates from. Can either be the guide currently
    * being viewed or one of its prerequisites.
    */
   protected int mGuideid;

   /**
    * The unique stepid that identifies this step.
    */
   protected int mStepid;

   /**
    * The step's revisionid or null if this is a new step.
    */
   protected Integer mRevisionid;

   /**
    * The step's 1-indexed orderby in the original guide.
    */
   protected int mOrderby;

   /**
    * 1-indexed step number for this step. This changes if prerequisites
    * are included in the guide.
    */
   protected int mStepNum;

   protected String mTitle;
   protected ArrayList<Image> mImages;
   protected ArrayList<StepLine> mLines;
   protected Video mVideo;
   private Embed mEmbed;
   protected boolean mEditMode; // save state for edit drop down

   public void setEditMode(boolean editMode) {
      mEditMode = editMode;
   }

   public boolean getEditMode() {
      return mEditMode;
   }

   public GuideStep(int stepNum) {
      mStepNum = stepNum;
      mTitle = "";
      mImages = new ArrayList<Image>();
      mLines = new ArrayList<StepLine>();
      mRevisionid = null;
   }

   public String type() {
      if (mVideo != null) {
         return "video";
      } else if (mEmbed != null) {
         return "embed";
      } else {
         return "image";
      }
   }

   public int getGuideid() {
      return mGuideid;
   }

   public void setGuideid(int guideid) {
      mGuideid = guideid;
   }

   public void setStepid(int stepid) {
      mStepid = stepid;
   }

   public void setStepNum(int stepNum) {
      mStepNum = stepNum;
   }

   public int getStepid() {
      return mStepid;
   }

   public void setRevisionid(Integer revisionid) {
      mRevisionid = revisionid;
   }

   public void setOrderby(int orderby) {
      mOrderby = orderby;
   }

   public void setTitle(String title) {
      mTitle = title;
   }

   public String getTitle() {
      return mTitle;
   }

   public int getStepNum() {
      return mStepNum;
   }

   public void addImage(Image image) {
      mImages.add(image);
   }

   public ArrayList<Image> getImages() {
      return mImages;
   }

   public void setImages(ArrayList<Image> images) {
      mImages.clear();
      mImages = new ArrayList<Image>(images);
   }

   public ArrayList<StepLine> getLines() {
      return mLines;
   }

   public void addLine(StepLine line) {
      mLines.add(line);
   }

   public void setLines(ArrayList<StepLine> lines) {
      mLines.clear();
      mLines = new ArrayList<StepLine>(lines);
   }

   public void addVideo(Video stepvid) {
      mVideo = stepvid;
   }

   public boolean hasVideo() {
      return mVideo != null;
   }

   public Video getVideo() {
      return mVideo;
   }

   public void addEmbed(Embed parseEmbed) {
      mEmbed = parseEmbed;
   }

   public boolean hasEmbed() {
      return mEmbed != null;
   }

   public Embed getEmbed() {
      return mEmbed;
   }

   public String toString() {
      return "{GuideStep: " + mGuideid + ", " + mStepid + ", " + mRevisionid + ", " +
       mOrderby + ", " + mStepNum + ", " + mTitle + ", " + mLines + ", " + mImages + "}";
   }


   public Integer getRevisionid() {
      return mRevisionid;
   }
}
