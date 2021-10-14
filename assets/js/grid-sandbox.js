window.onload = function () {

  function getEventElement(mouseEvent) {
    let event = mouseEvent || window.event;
    return event.target || event.srcElement;
  }

  function getReferenceElements(element, attr, refIdAttr) {
    let id = element.getAttribute(attr)
    return document.querySelectorAll(`[${refIdAttr}="${id}"]`);
  }

  function getSourceElement(element, srcIdAttr, refIdAttr) {
    let referenceId = element.getAttribute(refIdAttr)
    return document.querySelector(`[${srcIdAttr}="${referenceId}"]`);
  }

  function addClass(element, aClass) {
    element.classList.add(aClass)
  }

  function removeClass(element, aClass) {
    element.classList.remove(aClass)
  }

  function addReferenceClasses(element, attr, refIdAttr, highlightClass) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr, refIdAttr);
      for (const refElement of referenceElements) {
        addClass(refElement, highlightClass);
      }
    }
  }

  function removeReferenceClasses(element, attr, refIdAttr, highlightClass) {
    if (element.hasAttribute(attr)) {
      let referenceElements = getReferenceElements(element, attr, refIdAttr);
      for (const refElement of referenceElements) {
        removeClass(refElement, highlightClass);
      }
    }
  }

  function addClassesForIdAttrs(element, srcIdAttr, refIdAttr, refHighlightClass, srcHighlightClass) {
    addReferenceClasses(element, srcIdAttr, refIdAttr, refHighlightClass);
    addReferenceClasses(element, refIdAttr, refIdAttr, refHighlightClass);
    if (element.hasAttribute(refIdAttr)) {
      let sourceElement = getSourceElement(element, srcIdAttr, refIdAttr);
      addClass(sourceElement, srcHighlightClass);
    }
  }

  function removeClassesForIdAttrs(element, srcIdAttr, refIdAttr, refHighlightClass, srcHighlightClass) {
    removeReferenceClasses(element, srcIdAttr, refIdAttr, refHighlightClass);
    removeReferenceClasses(element, refIdAttr, refIdAttr, refHighlightClass);
    if (element.hasAttribute(refIdAttr)) {
      let sourceElement = getSourceElement(element, srcIdAttr, refIdAttr);
      removeClass(sourceElement, srcHighlightClass);
    }
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
    addClassesForIdAttrs(element, sourceIdAttr, referenceIdAttr, referenceHighlightClass, sourceHighlightClass);
    addClassesForIdAttrs(element, originIdAttr, originReferenceIdAttr, originReferenceHighlightClass, originSourceHighlightClass);
  };

  document.onmouseout = function (event) {
    let element = getEventElement(event);
    removeClassesForIdAttrs(element, sourceIdAttr, referenceIdAttr, referenceHighlightClass, sourceHighlightClass);
    removeClassesForIdAttrs(element, originIdAttr, originReferenceIdAttr, originReferenceHighlightClass, originSourceHighlightClass);
  };

}
