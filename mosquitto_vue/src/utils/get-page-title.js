import defaultSettings from '@/settings'

const title = defaultSettings.title || '威尔生产运营管理系统'

export default function getPageTitle(pageTitle) {
  
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
