window.onload = function () {

  function getEventElement(mouseEvent) {
    let event = mouseEvent || window.event;
    return event.target || event.srcElement;
  }

  function getReferenceElements(element, attr, refIdAttr) {
    let id = element.getAttribute(attr)
    return document.querySelectorAll(`[${refIdAttr}="${id}"]`);
  }

  function addReferenceClasses(element, attr, refIdAttr, highlightClass) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr, refIdAttr);
      for (const refElement of referenceElements) {
        refElement.classList.add(highlightClass)
      }
    }
  }

  function removeReferenceClasses(element, attr, refIdAttr, highlightClass) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr, refIdAttr);
      for (const refElement of referenceElements) {
        refElement.classList.remove(highlightClass)
      }
    }
  }

  function addClassesForIdAttrs(element, srcIdAttr, refIdAttr, refHighlightClass, srcHighlightClass, showSiblingReferences) {
    addReferenceClasses(element, srcIdAttr, refIdAttr, refHighlightClass);
    if (showSiblingReferences) {
      addReferenceClasses(element, refIdAttr, refIdAttr, refHighlightClass);
    }
    addReferenceClasses(element, refIdAttr, srcIdAttr, srcHighlightClass);
  }

  function removeClassesForIdAttrs(element, srcIdAttr, refIdAttr, refHighlightClass, srcHighlightClass, showSiblingReferences) {
    removeReferenceClasses(element, srcIdAttr, refIdAttr, refHighlightClass);
    if (showSiblingReferences) {
      removeReferenceClasses(element, refIdAttr, refIdAttr, refHighlightClass);
    }
    removeReferenceClasses(element, refIdAttr, srcIdAttr, srcHighlightClass);
  }

  const sourceIdAttr = "sourceId";
  const referenceIdAttr = "referenceId";
  const originIdAttr = "originId";
  const originReferenceIdAttr = "originReferenceId";

  const referenceHighlightClass = "reference-highlight";
  const sourceHighlightClass = "source-highlight";
  const originReferenceHighlightClass = "origin-reference-highlight";
  const originSourceHighlightClass = "origin-source-highlight";

  document.onmouseover = function (event) {
    let element = getEventElement(event);
    addClassesForIdAttrs(element, sourceIdAttr, referenceIdAttr, referenceHighlightClass, sourceHighlightClass, true);
    addClassesForIdAttrs(element, originIdAttr, originReferenceIdAttr, originReferenceHighlightClass, originSourceHighlightClass, false);
  };

  document.onmouseout = function (event) {
    let element = getEventElement(event);
    removeClassesForIdAttrs(element, sourceIdAttr, referenceIdAttr, referenceHighlightClass, sourceHighlightClass, true);
    removeClassesForIdAttrs(element, originIdAttr, originReferenceIdAttr, originReferenceHighlightClass, originSourceHighlightClass, false);
  };

}
